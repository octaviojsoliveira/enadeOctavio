/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.converter;

import com.mycompany.enade.dao.ProvaDao;
import com.mycompany.enade.model.Prova;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Octávio
 */
@FacesConverter(value = "provaConverter")
public class ProvaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Prova) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Prova) {
            Prova objt = (Prova) value;
            if (objt != null && objt instanceof Prova && objt.getIdProva()!= null) {
                uic.getAttributes().put(objt.getIdProva().toString(), objt);
                return objt.getIdProva().toString();
            }
        }
        return "";
    }
}