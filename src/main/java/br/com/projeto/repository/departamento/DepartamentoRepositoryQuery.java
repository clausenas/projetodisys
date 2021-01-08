package br.com.projeto.repository.departamento;

import java.util.List;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;

public interface DepartamentoRepositoryQuery {
	List<Funcionario> listarFuncionarioPorDepartamento(Departamento departamento);
}
