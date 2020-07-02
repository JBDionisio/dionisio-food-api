package com.dionisio.dionisiofoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dionisio.dionisiofoodapi.domain.model.Cozinha;
import com.dionisio.dionisiofoodapi.domain.repository.CozinhaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = em.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    @Override
    public Cozinha buscar(Long id) {       
        return em.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return em.merge(cozinha);
    }

    @Transactional
    @Override
    public void remover(Cozinha cozinha) {
        cozinha = buscar(cozinha.getId());
        em.remove(cozinha);
    }
    
}