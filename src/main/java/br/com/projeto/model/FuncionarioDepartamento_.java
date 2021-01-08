package br.com.projeto.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FuncionarioDepartamento.class)
public abstract class FuncionarioDepartamento_ {

	public static volatile SingularAttribute<FuncionarioDepartamento, Boolean> atual;
	public static volatile SingularAttribute<FuncionarioDepartamento, Departamento> departamento;
	public static volatile SingularAttribute<FuncionarioDepartamento, Long> id;
	public static volatile SingularAttribute<FuncionarioDepartamento, Funcionario> funcionario;

	public static final String ATUAL = "atual";
	public static final String DEPARTAMENTO = "departamento";
	public static final String ID = "id";
	public static final String FUNCIONARIO = "funcionario";

}

