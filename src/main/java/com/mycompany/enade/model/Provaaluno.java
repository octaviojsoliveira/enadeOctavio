/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Octávio
 */
@Entity
@Table(name = "provaaluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provaaluno.findAll", query = "SELECT p FROM Provaaluno p")
    , @NamedQuery(name = "Provaaluno.findByIdProvaAluno", query = "SELECT p FROM Provaaluno p WHERE p.idProvaAluno = :idProvaAluno")})
public class Provaaluno implements Serializable {

    @OneToMany(mappedBy = "idProvaAluno")
    private List<Resposta> respostaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProvaAluno")
    private Long idProvaAluno;
    @JoinColumn(name = "idProva", referencedColumnName = "idProva")
    @ManyToOne
    private Prova idProva;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuario;

    public Provaaluno() {
    }

    public Provaaluno(Long idProvaAluno) {
        this.idProvaAluno = idProvaAluno;
    }

    public Long getIdProvaAluno() {
        return idProvaAluno;
    }

    public void setIdProvaAluno(Long idProvaAluno) {
        this.idProvaAluno = idProvaAluno;
    }

    public Prova getIdProva() {
        return idProva;
    }

    public void setIdProva(Prova idProva) {
        this.idProva = idProva;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvaAluno != null ? idProvaAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provaaluno)) {
            return false;
        }
        Provaaluno other = (Provaaluno) object;
        if ((this.idProvaAluno == null && other.idProvaAluno != null) || (this.idProvaAluno != null && !this.idProvaAluno.equals(other.idProvaAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Provaaluno[ idProvaAluno=" + idProvaAluno + " ]";
    }

    @XmlTransient
    public List<Resposta> getRespostaList() {
        return respostaList;
    }

    public void setRespostaList(List<Resposta> respostaList) {
        this.respostaList = respostaList;
    }
    
}
