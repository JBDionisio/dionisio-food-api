package com.dionisio.dionisiofoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dionisio.dionisiofoodapi.domain.model.Estado;
import com.dionisio.dionisiofoodapi.domain.repository.EstadoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Estado> listar() {
        TypedQuery<Estado> query = em.createQuery("from Estado", Estado.class);
        return query.getResultList();
    }

    @Override
    public Estado buscar(Long id) {       
        return em.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return em.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Estado estado) {
        estado = buscar(estado.getId());
        em.remove(estado);
    }

}