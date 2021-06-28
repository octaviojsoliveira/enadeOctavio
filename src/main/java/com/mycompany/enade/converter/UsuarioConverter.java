/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.converter;

import com.mycompany.enade.dao.UsuarioDao;
import com.mycompany.enade.model.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Octávio
 */
@FacesConverter(value = "usuarioConverter")
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Usuario) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Usuario) {
            Usuario objt = (Usuario) value;
            if (objt != null && objt instanceof Usuario && objt.getIdUsuario()!= null) {
                uic.getAttributes().put(objt.getIdUsuario().toString(), objt);
                return objt.getIdUsuario().toString();
            }
        }
        return "";
    }
}