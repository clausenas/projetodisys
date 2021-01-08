package br.com.projeto.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ {

	public static volatile SingularAttribute<Funcionario, String> funcionarioDucument;
	public static volatile SingularAttribute<Funcionario, Integer> funcionarioAge;
	public static volatile SingularAttribute<Funcionario, String> funcionarioNome;
	public static volatile SingularAttribute<Funcionario, Long> id;
	public static volatile SingularAttribute<Funcionario, Cargo> cargo;
	public static volatile SingularAttribute<Funcionario, LocalDate> funcionarioBirthday;

	public static final String FUNCIONARIO_DUCUMENT = "funcionarioDucument";
	public static final String FUNCIONARIO_AGE = "funcionarioAge";
	public static final String FUNCIONARIO_NOME = "funcionarioNome";
	public static final String ID = "id";
	public static final String CARGO = "cargo";
	public static final String FUNCIONARIO_BIRTHDAY = "funcionarioBirthday";

}

