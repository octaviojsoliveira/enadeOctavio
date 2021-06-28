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
import com.mycompany.enade.model.Usuario;

/**
 *
 * @author Octávio
 */

public class UsuarioDao {
    public static UsuarioDao usuarioDao;
    
    public static UsuarioDao getInstance(){
        if(usuarioDao == null){
            usuarioDao = new UsuarioDao();
        }
        return usuarioDao;
    }
    
    public Usuario buscar(String nomeUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select u from Usuario u where u.nomeUsuario =:nomeUsuario ");
        query.setParameter("nomeUsuario", nomeUsuario);

        List<Usuario> usuarios = query.getResultList();
        if (usuarios != null && usuarios.size() > 0) {
            return usuarios.get(0);
        }

        return null;
    }

    public List<Usuario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Usuario As u");
        return query.getResultList();
    }
    
    public List<Usuario> buscarAlunos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Usuario As u where u.tipoUsuario = 'Aluno'");
        return query.getResultList();
    }
            
    public List<Usuario> buscarUsuarioeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct u from Usuario u group by u.nomeUsuario");
        return query.getResultList();
    }

        public List<Usuario> buscarUsuarioeTypeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct u from Usuario u group by u.tipoUsuario");
        return query.getResultList();
    }

        public void excluir(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(usuario)) {
            usuario = em.merge(usuario);
        }
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public Usuario persistir(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            usuario = em.merge(usuario);
            em.getTransaction().commit();
            System.out.println("Registro Usuario gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from Usuario ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
    
    public Usuario getLogin(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery(
            "select u from Usuario u where u.emailUsuario =:emailUsuario "
            + "and u.senhaUsuario = :senhaUsuario");
        query.setParameter("emailUsuario", usuario.getEmailUsuario());
        query.setParameter("senhaUsuario", usuario.getSenhaUsuario());
        
        List<Usuario> usuariosRetornados = query.getResultList();
        if (usuariosRetornados != null && usuariosRetornados.size() > 0) {
            return usuariosRetornados.get(0);
        }
        return null;
    }
    
}
