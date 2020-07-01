package com.dionisio.dionisiofoodapi.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dionisio.dionisiofoodapi.model.Cozinha;

import org.springframework.stereotype.Service;

@Service
public class CozinhaService {

    @PersistenceContext
    private EntityManager em;

    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = em.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

}