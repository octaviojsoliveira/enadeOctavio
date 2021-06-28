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
import com.mycompany.enade.model.Provaquestao;

/**
 *
 * @author Octávio
 */
public class ProvaQuestaoDao {
    public static ProvaQuestaoDao pqDao;
    
    public static ProvaQuestaoDao getInstance() {
        if (pqDao == null) {
            pqDao = new ProvaQuestaoDao();
        }
        return pqDao;
    }
    
    public Provaquestao buscar(Long idProvaQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select p from Provaquestao p where p.idProvaQuestao =:idProvaQuestao ");
        query.setParameter("idProvaQuestao", idProvaQuestao);

        List<Provaquestao> provaList = query.getResultList();
        if (provaList != null && provaList.size() > 0) {
            return provaList.get(0);
        }
        return null;
    }
    
    public List<Provaquestao> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Provaquestao As p");
        return query.getResultList();
    }
    
    public List<Provaquestao> buscarProvaInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct p from Provaquestao p ");
        return query.getResultList();
    }
    
    public void remover(Provaquestao pq) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(pq)) {
            pq = em.merge(pq);
        }
        em.remove(pq);
        em.getTransaction().commit();
    }
    
    public Provaquestao persistir(Provaquestao pq) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            pq = em.merge(pq);
            em.getTransaction().commit();
            System.out.println("Registro Provaquestao gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pq;
    }
}