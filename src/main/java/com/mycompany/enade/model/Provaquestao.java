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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Octávio
 */
@Entity
@Table(name = "provaquestao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provaquestao.findAll", query = "SELECT p FROM ProvaQuestao p")
    , @NamedQuery(name = "Provaquestao.findByIdProvaQuestao", query = "SELECT p FROM ProvaQuestao p WHERE p.idProvaQuestao = :idProvaQuestao")})
public class Provaquestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProvaQuestao")
    private Long idProvaQuestao;
    @JoinColumn(name = "idProva", referencedColumnName = "idProva")
    @ManyToOne
    private Prova idProva;
    @JoinColumn(name = "idQuestao", referencedColumnName = "idQuestao")
    @ManyToOne
    private Questao idQuestao;

    public Provaquestao() {
    }

    public Provaquestao(Long idProvaQuestao) {
        this.idProvaQuestao = idProvaQuestao;
    }

    public Long getIdProvaQuestao() {
        return idProvaQuestao;
    }

    public void setIdProvaQuestao(Long idProvaQuestao) {
        this.idProvaQuestao = idProvaQuestao;
    }

    public Prova getIdProva() {
        return idProva;
    }

    public void setIdProva(Prova idProva) {
        this.idProva = idProva;
    }

    public Questao getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Questao idQuestao) {
        this.idQuestao = idQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvaQuestao != null ? idProvaQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provaquestao)) {
            return false;
        }
        Provaquestao other = (Provaquestao) object;
        if ((this.idProvaQuestao == null && other.idProvaQuestao != null) || (this.idProvaQuestao != null && !this.idProvaQuestao.equals(other.idProvaQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Provaquestao[ idProvaQuestao=" + idProvaQuestao + " ]";
    }
    
}
