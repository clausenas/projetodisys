package br.com.projeto.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departamento.class)
public abstract class Departamento_ {

	public static volatile SingularAttribute<Departamento, Funcionario> chefeDeparmento;
	public static volatile SingularAttribute<Departamento, Long> id;
	public static volatile SingularAttribute<Departamento, String> departamentoName;

	public static final String CHEFE_DEPARMENTO = "chefeDeparmento";
	public static final String ID = "id";
	public static final String DEPARTAMENTO_NAME = "departamentoName";

}

