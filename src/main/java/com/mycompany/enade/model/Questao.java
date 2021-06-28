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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Octávio
 */
@Entity
@Table(name = "questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q")
    , @NamedQuery(name = "Questao.findByIdQuestao", query = "SELECT q FROM Questao q WHERE q.idQuestao = :idQuestao")
    , @NamedQuery(name = "Questao.findByTipoQuestao", query = "SELECT q FROM Questao q WHERE q.tipoQuestao = :tipoQuestao")
    , @NamedQuery(name = "Questao.findByDescricaoQuestao", query = "SELECT q FROM Questao q WHERE q.descricaoQuestao = :descricaoQuestao")
    , @NamedQuery(name = "Questao.findByAlternativaA", query = "SELECT q FROM Questao q WHERE q.alternativaA = :alternativaA")
    , @NamedQuery(name = "Questao.findByAlternativaB", query = "SELECT q FROM Questao q WHERE q.alternativaB = :alternativaB")
    , @NamedQuery(name = "Questao.findByAlternativaC", query = "SELECT q FROM Questao q WHERE q.alternativaC = :alternativaC")
    , @NamedQuery(name = "Questao.findByAlternativaD", query = "SELECT q FROM Questao q WHERE q.alternativaD = :alternativaD")
    , @NamedQuery(name = "Questao.findByAlternativaE", query = "SELECT q FROM Questao q WHERE q.alternativaE = :alternativaE")
    , @NamedQuery(name = "Questao.findByQuestaoCorreta", query = "SELECT q FROM Questao q WHERE q.questaoCorreta = :questaoCorreta")
    , @NamedQuery(name = "Questao.findByEstadoQuestao", query = "SELECT q FROM Questao q WHERE q.estadoQuestao = :estadoQuestao")})
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuestao")
    private Long idQuestao;
    @Size(max = 21)
    @Column(name = "tipoQuestao")
    private String tipoQuestao;
    @Size(max = 45)
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;
    @Size(max = 45)
    @Column(name = "alternativaA")
    private String alternativaA;
    @Size(max = 45)
    @Column(name = "alternativaB")
    private String alternativaB;
    @Size(max = 45)
    @Column(name = "alternativaC")
    private String alternativaC;
    @Size(max = 45)
    @Column(name = "alternativaD")
    private String alternativaD;
    @Size(max = 45)
    @Column(name = "alternativaE")
    private String alternativaE;
    @Size(max = 2)
    @Column(name = "questaoCorreta")
    private String questaoCorreta;
    @Size(max = 8)
    @Column(name = "estadoQuestao")
    private String estadoQuestao;
    @OneToMany(mappedBy = "idQuestao")
    private List<Provaquestao> provaquestaoList;

    public Questao() {
    }

    public Questao(Long idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Long getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Long idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(String tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public String getQuestaoCorreta() {
        return questaoCorreta;
    }

    public void setQuestaoCorreta(String questaoCorreta) {
        this.questaoCorreta = questaoCorreta;
    }

    public String getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(String estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    @XmlTransient
    public List<Provaquestao> getProvaquestaoList() {
        return provaquestaoList;
    }

    public void setProvaquestaoList(List<Provaquestao> provaquestaoList) {
        this.provaquestaoList = provaquestaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Questao[ idQuestao=" + idQuestao + " ]";
    }
    
}
