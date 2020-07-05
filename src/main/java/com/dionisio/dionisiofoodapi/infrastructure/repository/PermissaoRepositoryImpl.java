package com.dionisio.dionisiofoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dionisio.dionisiofoodapi.domain.model.Permissao;
import com.dionisio.dionisiofoodapi.domain.repository.PermissaoRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PermissaoRepositoryImpl implements PermissaoRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Permissao> listar() {
        TypedQuery<Permissao> query = em.createQuery("from Permissao", Permissao.class);
        return query.getResultList();
    }

    @Override
    public Permissao buscar(Long id) {       
        return em.find(Permissao.class, id);
    }

    @Transactional
    @Override
    public Permissao salvar(Permissao permissao) {
        return em.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao) {
        permissao = buscar(permissao.getId());
        em.remove(permissao);
    }

}