package br.com.projeto.repository.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
