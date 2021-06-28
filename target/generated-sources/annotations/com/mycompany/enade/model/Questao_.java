package com.mycompany.enade.model;

import com.mycompany.enade.model.Provaquestao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-28T17:50:43")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile SingularAttribute<Questao, String> alternativaE;
    public static volatile SingularAttribute<Questao, String> tipoQuestao;
    public static volatile SingularAttribute<Questao, String> alternativaD;
    public static volatile SingularAttribute<Questao, String> alternativaC;
    public static volatile SingularAttribute<Questao, String> alternativaB;
    public static volatile SingularAttribute<Questao, String> alternativaA;
    public static volatile SingularAttribute<Questao, Long> idQuestao;
    public static volatile SingularAttribute<Questao, String> descricaoQuestao;
    public static volatile SingularAttribute<Questao, String> estadoQuestao;
    public static volatile SingularAttribute<Questao, String> questaoCorreta;
    public static volatile ListAttribute<Questao, Provaquestao> provaquestaoList;

}