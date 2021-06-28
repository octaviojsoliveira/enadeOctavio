/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.util.PersistenceUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.mycompany.enade.model.Resposta;

/**
 *
 * @author Octávio
 */

public class RespostaDao {
    public static RespostaDao respostaDao;
    
    public static RespostaDao getInstance(){
        if(respostaDao == null){
            respostaDao = new RespostaDao();
        }
        return respostaDao;
    }
    
    public Resposta buscar(Long idResposta) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select r from Resposta r where r.idResposta =:idResposta ");
        query.setParameter("idResposta", idResposta);

        List<Resposta> respostas = query.getResultList();
        if (respostas != null && respostas.size() > 0) {
            return respostas.get(0);
        }

        return null;
    }

    public List<Resposta> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Resposta As r");
        return query.getResultList();
    }

        public void excluir(Resposta resposta) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(resposta)) {
            resposta = em.merge(resposta);
        }
        em.remove(resposta);
        em.getTransaction().commit();
    }

    public Resposta persistir(Resposta resposta) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            resposta = em.merge(resposta);
            em.getTransaction().commit();
            System.out.println("Registro Resposta gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resposta;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from Resposta ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
   
}
