/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.bean;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.mycompany.enade.model.Usuario;
import com.mycompany.enade.dao.UsuarioDao;
import java.io.File;
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
import com.mycompany.enade.util.Relatorio;

/**
 *
 * @author Octávio
 */

public class UsuarioBean{
    
    Usuario usuario = new Usuario();
    List usuarios = new ArrayList();
    List alunos = new ArrayList();

    public UsuarioBean() {
        usuarios = new UsuarioDao().buscarTodas();
        usuario = new Usuario();
        alunos = new UsuarioDao().buscarAlunos();
    } 
    
    public void record(ActionEvent actionEvent) {
        new UsuarioDao().persistir(usuario);
        usuarios = new UsuarioDao().buscarTodas();
        usuario = new Usuario();
    }

    public void exclude(ActionEvent actionEvent) {
        new UsuarioDao().excluir(usuario);
        usuarios = new UsuarioDao().buscarTodas();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    public List getAlunos() {
        return alunos;
    }

    public void setAlunos(List alunos) {
        this.alunos = alunos;
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
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "uniacademia.png";

        pdf.add(Image.getInstance(logo));
    }
    
    public void login() throws IOException {
        Usuario usuarioLogado = new UsuarioDao().getLogin(this.usuario);
        
        if (usuarioLogado != null)
        {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session.setAttribute("usuario", usuarioLogado);
            
            response.sendRedirect("index.xhtml");
        }
        else
        {
//            FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN,
//							"Login ou senha incorretos!",
//							"Favor inserir usuário e senha novamente!"));
            
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("cadastro.xhtml");
        }
    }
    
    public void gerarRelatorio() throws IOException {
        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorioAluno(usuarios);
    }
    
}
