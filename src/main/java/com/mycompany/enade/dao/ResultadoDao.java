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
import com.mycompany.enade.model.Resultado;

/**
 *
 * @author Octávio
 */
public class ResultadoDao {
    public static ResultadoDao resultadoDao;

    public static ResultadoDao getInstance() {
        if (resultadoDao == null) {
            resultadoDao = new ResultadoDao();
        }
        return resultadoDao;
    }
    
    public Resultado buscar(Long idResultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select r from Resultado r where r.idResultado =:idResultado ");
        query.setParameter("idResultado", idResultado);

        List<Resultado> provaList = query.getResultList();
        if (provaList != null && provaList.size() > 0) {
            return provaList.get(0);
        }
        return null;
    }
    
    public List<Resultado> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Resultado As r");
        return query.getResultList();
    }

    public List<Resultado> buscarProvaInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct r from Resultado r ");
        return query.getResultList();
    }
    
    public void remover(Resultado resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(resultado)) {
            resultado = em.merge(resultado);
        }
        em.remove(resultado);
        em.getTransaction().commit();
    }

    public Resultado persistir(Resultado resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            resultado = em.merge(resultado);
            em.getTransaction().commit();
            System.out.println("Registro resultado gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
