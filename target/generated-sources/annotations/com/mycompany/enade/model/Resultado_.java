package com.mycompany.enade.model;

import com.mycompany.enade.model.Prova;
import com.mycompany.enade.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-28T17:50:43")
@StaticMetamodel(Resultado.class)
public class Resultado_ { 

    public static volatile SingularAttribute<Resultado, Prova> idProva;
    public static volatile SingularAttribute<Resultado, Double> valorObtido;
    public static volatile SingularAttribute<Resultado, Usuario> idUsuario;
    public static volatile SingularAttribute<Resultado, Long> idResultado;

}