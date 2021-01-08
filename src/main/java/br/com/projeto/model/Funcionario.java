package br.com.projeto.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String funcionarioNome;
	private Integer funcionarioAge;
	private LocalDate funcionarioBirthday;
	private String funcionarioDucument;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cargo_id", referencedColumnName = "id")
	private Cargo cargo;

	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
}
