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
import com.mycompany.enade.model.Prova;

/**
 *
 * @author Octávio
 */
public class ProvaDao {
    public static ProvaDao provaDao;

    public static ProvaDao getInstance() {
        if (provaDao == null) {
            provaDao = new ProvaDao();
        }
        return provaDao;
    }
    
    public Prova buscar(Long idProva) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select p from Prova p where p.idProva =:idProva ");
        query.setParameter("idProva", idProva);

        List<Prova> provaList = query.getResultList();
        if (provaList != null && provaList.size() > 0) {
            return provaList.get(0);
        }
        return null;
    }
    
    public List<Prova> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Prova As p");
        return query.getResultList();
    }

    public List<Prova> buscarProvaInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct p from Prova p ");
        return query.getResultList();
    }
    
    public void remover(Prova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(prova)) {
            prova = em.merge(prova);
        }
        em.remove(prova);
        em.getTransaction().commit();
    }

    public Prova persistir(Prova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            prova = em.merge(prova);
            em.getTransaction().commit();
            System.out.println("Registro prova gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prova;
    }
}
