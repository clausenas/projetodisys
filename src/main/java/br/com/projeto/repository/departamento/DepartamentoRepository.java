package br.com.projeto.repository.departamento;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>, DepartamentoRepositoryQuery{

	Optional<Departamento> findByDepartamentoName(String departamentoName);
}
