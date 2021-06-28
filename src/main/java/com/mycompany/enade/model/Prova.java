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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Octávio
 */
@Entity
@Table(name = "prova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prova.findAll", query = "SELECT p FROM Prova p")
    , @NamedQuery(name = "Prova.findByIdProva", query = "SELECT p FROM Prova p WHERE p.idProva = :idProva")
    , @NamedQuery(name = "Prova.findByDataProva", query = "SELECT p FROM Prova p WHERE p.dataProva = :dataProva")})
public class Prova implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProva")
    private Long idProva;
    @Column(name = "dataProva")
    private Integer dataProva;
    @OneToMany(mappedBy = "idProva")
    private List<Resultado> resultadoList;
    @OneToMany(mappedBy = "idProva")
    private List<Provaquestao> provaquestaoList;
    @OneToMany(mappedBy = "idProva")
    private List<Provaaluno> provaalunoList;

    public Prova() {
    }

    public Prova(Long idProva) {
        this.idProva = idProva;
    }

    public Long getIdProva() {
        return idProva;
    }

    public void setIdProva(Long idProva) {
        this.idProva = idProva;
    }

    public Integer getDataProva() {
        return dataProva;
    }

    public void setDataProva(Integer dataProva) {
        this.dataProva = dataProva;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    @XmlTransient
    public List<Provaquestao> getProvaquestaoList() {
        return provaquestaoList;
    }

    public void setProvaquestaoList(List<Provaquestao> provaquestaoList) {
        this.provaquestaoList = provaquestaoList;
    }
    
    @XmlTransient
    public List<Provaaluno> getProvaalunoList() {
        return provaalunoList;
    }

    public void setProvaalunoList(List<Provaaluno> provaalunoList) {
        this.provaalunoList = provaalunoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Prova[ idProva=" + idProva + " ]";
    }
    
}
