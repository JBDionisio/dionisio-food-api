package com.dionisio.dionisiofoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dionisio.dionisiofoodapi.domain.model.Cidade;
import com.dionisio.dionisiofoodapi.domain.repository.CidadeRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cidade> listar() {
        TypedQuery<Cidade> query = em.createQuery("from Cidade", Cidade.class);
        return query.getResultList();
    }

    @Override
    public Cidade buscar(Long id) {       
        return em.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return em.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Cidade cidade) {
        cidade = buscar(cidade.getId());
        em.remove(cidade);
    }

}