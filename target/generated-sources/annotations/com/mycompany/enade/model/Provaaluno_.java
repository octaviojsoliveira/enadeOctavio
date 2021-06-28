package com.mycompany.enade.model;

import com.mycompany.enade.model.Prova;
import com.mycompany.enade.model.Resposta;
import com.mycompany.enade.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-28T17:50:43")
@StaticMetamodel(Provaaluno.class)
public class Provaaluno_ { 

    public static volatile SingularAttribute<Provaaluno, Long> idProvaAluno;
    public static volatile SingularAttribute<Provaaluno, Prova> idProva;
    public static volatile SingularAttribute<Provaaluno, Usuario> idUsuario;
    public static volatile ListAttribute<Provaaluno, Resposta> respostaList;

}