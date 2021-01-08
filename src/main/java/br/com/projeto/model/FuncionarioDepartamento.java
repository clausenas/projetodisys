package br.com.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FuncionarioDepartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	private Boolean atual;
	
	public FuncionarioDepartamento() {
		super();
	}
	

	public FuncionarioDepartamento(Departamento departamento, Funcionario funcionario) {
		super();
		this.departamento = departamento;
		this.funcionario = funcionario;
	}

}
