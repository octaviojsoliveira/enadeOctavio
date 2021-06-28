/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.converter;

import com.mycompany.enade.dao.ResultadoDao;
import com.mycompany.enade.model.Resultado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Octávio
 */
@FacesConverter(value = "resultadoConverter")
public class ResultadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Resultado) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Resultado) {
            Resultado objt = (Resultado) value;
            if (objt != null && objt instanceof Resultado && objt.getIdResultado()!= null) {
                uic.getAttributes().put(objt.getIdResultado().toString(), objt);
                return objt.getIdResultado().toString();
            }
        }
        return "";
    }
}