package com.mycompany.enade.model;

import com.mycompany.enade.model.Provaaluno;
import com.mycompany.enade.model.Provaquestao;
import com.mycompany.enade.model.Resultado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-28T17:50:43")
@StaticMetamodel(Prova.class)
public class Prova_ { 

    public static volatile ListAttribute<Prova, Provaaluno> provaalunoList;
    public static volatile SingularAttribute<Prova, Long> idProva;
    public static volatile ListAttribute<Prova, Resultado> resultadoList;
    public static volatile SingularAttribute<Prova, Integer> dataProva;
    public static volatile ListAttribute<Prova, Provaquestao> provaquestaoList;

}