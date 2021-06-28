/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.bean;

import com.mycompany.enade.util.Relatorio;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Octávio
 */

public class RelatorioBean {

    private String relatorio;
    
    private Map<String, String> tipos;
    
    public RelatorioBean() {
        tipos = new HashMap<>();
        tipos.put("Relatório de Alunos", "ListaAlunos");
        tipos.put("Relatório de Alunos X Notas", "AlunoXNota");
        tipos.put("Relatório de Alunos sem Prova", "AlunosPendentesSemProva");
        tipos.put("Relatório de Alunos com Prova Pendente", "AlunosPendentesComProva");
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Map<String, String> getTipos() {
        return tipos;
    }

    public void setTipos(Map<String, String> tipos) {
        this.tipos = tipos;
    }
    
    public void gerarRelatorio() {
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio(this.relatorio);
    }
    
}