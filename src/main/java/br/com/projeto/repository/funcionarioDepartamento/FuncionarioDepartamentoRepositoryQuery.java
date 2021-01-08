package br.com.projeto.repository.funcionarioDepartamento;

import java.util.List;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;

public interface FuncionarioDepartamentoRepositoryQuery {

	List<Funcionario> listarFuncionarioPorDepardamento(Departamento departamento);
}
