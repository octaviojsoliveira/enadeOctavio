/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import com.mycompany.enade.dao.UsuarioDao;
import com.mycompany.enade.model.Usuario;
import com.mycompany.enade.dao.ResultadoDao;
import java.util.Hashtable;
import java.util.List;
import javax.annotation.PostConstruct;
import com.mycompany.enade.model.Resultado;
import org.primefaces.model.chart.BarChartModel;

/**
 *
 * @author Octávio
 */
@Named(value="dashboardBean")
@RequestScoped
public class DashboardBean {
    
    private PieChartModel pieModel;
    private BarChartModel barModel;
    private List<Resultado> resultados;
    
    public DashboardBean() {
        resultados = new ResultadoDao().buscarTodas();
    }
    
    @PostConstruct
    public void init() {
    }
    
    public PieChartModel getPieModel() {
            return pieModel;
    }
    
    public void setPieModel(PieChartModel pieModel){
        this.pieModel = pieModel;
    }
    
    public BarChartModel getBarModel(){
        return barModel;
    }
    
    public void setBarModel(BarChartModel barModel){
        this.barModel = barModel;
    }
    
    
    public void listarResultado(){
        ResultadoDao resultadoDao;
        List<Resultado> listaResultado;
        
        try{
            resultadoDao = new ResultadoDao();
            listaResultado = resultadoDao.buscarTodas();
            graficar(listaResultado);
        }catch(Exception e){
            
        }
        
    }
    
    private void graficar(List<Resultado> listaResultado){
            pieModel = new PieChartModel();
            
            for(Resultado resultado :listaResultado){
                pieModel.set(resultado.getIdUsuario().getNomeUsuario(), resultado.getValorObtido());
            }
            pieModel.setTitle("Alunos");
            pieModel.setLegendPosition("e");
            pieModel.setFill(false);
            pieModel.setShowDataLabels(true);
            pieModel.setDiameter(150);
        }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
    
        
}
