/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.converter;

import com.mycompany.enade.dao.QuestaoDao;
import com.mycompany.enade.model.Questao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Octávio
 */
@FacesConverter(value = "questaoConverter")
public class QuestaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Questao) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Questao) {
            Questao objt = (Questao) value;
            if (objt != null && objt instanceof Questao && objt.getIdQuestao()!= null) {
                uic.getAttributes().put(objt.getIdQuestao().toString(), objt);
                return objt.getIdQuestao().toString();
            }
        }
        return "";
    }
}