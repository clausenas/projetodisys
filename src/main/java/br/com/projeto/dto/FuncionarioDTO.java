package br.com.projeto.dto;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;

public class FuncionarioDTO {
	private Funcionario funcionario;
	private Departamento departamento;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
		
}
