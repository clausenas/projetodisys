package br.com.projeto.repository.departamento;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;

public class DepartamentoRepositoryImpl implements DepartamentoRepositoryQuery{
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	
	public List<Funcionario> listarFuncionarioPorDepartamento(Departamento departamento) {
		
		return null;
	}

	
}
