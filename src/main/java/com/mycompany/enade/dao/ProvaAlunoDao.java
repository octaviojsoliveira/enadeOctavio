/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.mycompany.enade.model.Provaaluno;

/**
 *
 * @author Octávio
 */
public class ProvaAlunoDao {
    public static ProvaAlunoDao paDao;
    
    public static ProvaAlunoDao getInstance() {
        if (paDao == null) {
            paDao = new ProvaAlunoDao();
        }
        return paDao;
    }
    
    public Provaaluno buscar(Long idProvaAluno) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select p from Provaaluno p where p.idProvaAluno =:idProvaAluno ");
        query.setParameter("idProvaAluno", idProvaAluno);

        List<Provaaluno> paList = query.getResultList();
        if (paList != null && paList.size() > 0) {
            return paList.get(0);
        }
        return null;
    }
    
    public List<Provaaluno> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Provaaluno As p");
        return query.getResultList();
    }
    
    public List<Provaaluno> buscarProvaInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct p from Provaaluno p ");
        return query.getResultList();
    }
    
    public void remover(Provaaluno pa) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(pa)) {
            pa = em.merge(pa);
        }
        em.remove(pa);
        em.getTransaction().commit();
    }
    
    public Provaaluno persistir(Provaaluno pa) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            pa = em.merge(pa);
            em.getTransaction().commit();
            System.out.println("Registro Provaaluno gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pa;
    }
}