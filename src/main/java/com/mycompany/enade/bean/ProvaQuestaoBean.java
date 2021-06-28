/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.bean;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.mycompany.enade.model.Provaquestao;
import com.mycompany.enade.dao.ProvaQuestaoDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 *
 * @author Octávio
 */

public class ProvaQuestaoBean {
    Provaquestao pq = new Provaquestao();
    List pqs = new ArrayList();
    
    public ProvaQuestaoBean(){
        pqs = new ProvaQuestaoDao().buscarTodas();
        pq = new Provaquestao();
    }
    
    public void record(ActionEvent actionEvent){
        new ProvaQuestaoDao().persistir(pq);
        pqs = new ProvaQuestaoDao().buscarTodas();
        pq = new Provaquestao();
    }
    
    public void exclude(ActionEvent actionEvent){
        new ProvaQuestaoDao().remover(pq);
        pqs = new ProvaQuestaoDao().buscarTodas();
        pq = new Provaquestao();
    }
    
    public Provaquestao getPq(){
        return pq;
    }
    
    public void setPq(Provaquestao pq){
        this.pq = pq;
    }
    
    public List getPqss(){
        return pqs;
    }
    
    public void setPqss(List pqs){
        this.pqs = pqs;
    }
    
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);

            cell.setCellStyle(cellStyle);
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        //String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "prime_logo.png";

        // pdf.add(Image.getInstance(logo));
    }
}