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
import com.mycompany.enade.model.Questao;

/**
 *
 * @author Octávio
 */
public class QuestaoDao {
    public static QuestaoDao questaoDao;

    public static QuestaoDao getInstance() {
        if (questaoDao == null) {
            questaoDao = new QuestaoDao();
        }
        return questaoDao;
    }
    
    public Questao buscar(Long idQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select q from Questao q where q.idQuestao =:idQuestao ");
        query.setParameter("idQuestao", idQuestao);

        List<Questao> provaList = query.getResultList();
        if (provaList != null && provaList.size() > 0) {
            return provaList.get(0);
        }
        return null;
    }
    
    public List<Questao> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Questao As q");
        return query.getResultList();
    }
    
    public List<Questao> buscarValido() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Questao As q where q.estadoQuestao = 'Validado'");
        return query.getResultList();
    }
    
    public List<Questao> buscarProvaInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct q from Questao q ");
        return query.getResultList();
    }
    
    public Questao persistir(Questao questao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            questao = em.merge(questao);
            em.getTransaction().commit();
            System.out.println("Registro questao gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questao;
    }
    
}
