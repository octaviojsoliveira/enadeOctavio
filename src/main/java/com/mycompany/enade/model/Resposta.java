/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Octávio
 */
@Entity
@Table(name = "resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resposta.findAll", query = "SELECT r FROM Resposta r")
    , @NamedQuery(name = "Resposta.findByIdResposta", query = "SELECT r FROM Resposta r WHERE r.idResposta = :idResposta")
    , @NamedQuery(name = "Resposta.findByMarcacao", query = "SELECT r FROM Resposta r WHERE r.marcacao = :marcacao")})
public class Resposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResposta")
    private Long idResposta;
    @Size(max = 10)
    @Column(name = "marcacao")
    private String marcacao;
    @JoinColumn(name = "idProvaAluno", referencedColumnName = "idProvaAluno")
    @ManyToOne
    private Provaaluno idProvaAluno;

    public Resposta() {
    }

    public Resposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public Long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Long idResposta) {
        this.idResposta = idResposta;
    }

    public String getMarcacao() {
        return marcacao;
    }

    public void setMarcacao(String marcacao) {
        this.marcacao = marcacao;
    }

    public Provaaluno getIdProvaAluno() {
        return idProvaAluno;
    }

    public void setIdProvaAluno(Provaaluno idProvaAluno) {
        this.idProvaAluno = idProvaAluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Resposta[ idResposta=" + idResposta + " ]";
    }
    
}
