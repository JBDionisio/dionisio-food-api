package com.dionisio.dionisiofoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dionisio.dionisiofoodapi.domain.model.FormaPagamento;
import com.dionisio.dionisiofoodapi.domain.repository.FormaPagamentoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<FormaPagamento> listar() {
        TypedQuery<FormaPagamento> query = em.createQuery("from FormaPagamento", FormaPagamento.class);
        return query.getResultList();
    }

    @Override
    public FormaPagamento buscar(Long id) {       
        return em.find(FormaPagamento.class, id);
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return em.merge(formaPagamento);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento formaPagamento) {
        formaPagamento = buscar(formaPagamento.getId());
        em.remove(formaPagamento);
    }

}