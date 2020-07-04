package com.dionisio.dionisiofoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dionisio.dionisiofoodapi.domain.model.Restaurante;
import com.dionisio.dionisiofoodapi.domain.repository.RestauranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Restaurante> listar() {
        TypedQuery<Restaurante> query = em.createQuery("from Restaurante", Restaurante.class);
        return query.getResultList();
    }

    @Override
    public Restaurante buscar(Long id) {
        return em.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return em.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        restaurante = buscar(restaurante.getId());
        em.remove(restaurante);
    }
    
}