package br.com.projeto.repository.funcionarioDepartamento;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;
import br.com.projeto.model.FuncionarioDepartamento;

public interface FuncionarioDepartamentoRepository extends JpaRepository<FuncionarioDepartamento, Long>, FuncionarioDepartamentoRepositoryQuery {

	List<FuncionarioDepartamento> findByFuncionario(Funcionario funcionario);
	Optional<FuncionarioDepartamento> findByFuncionarioAndDepartamento(Funcionario funcionario, Departamento departamento);
}
