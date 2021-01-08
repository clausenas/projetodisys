package br.com.projeto.repository.funcionarioDepartamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Departamento_;
import br.com.projeto.model.Funcionario;
import br.com.projeto.model.FuncionarioDepartamento;
import br.com.projeto.model.FuncionarioDepartamento_;

public class FuncionarioDepartamentoRepositoryImpl implements FuncionarioDepartamentoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Funcionario> listarFuncionarioPorDepardamento(Departamento departamento) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
		Root<FuncionarioDepartamento> root = criteria.from(FuncionarioDepartamento.class);
		
		criteria.select(root.get(FuncionarioDepartamento_.funcionario));
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		predicates.add(builder.equal(root.get(FuncionarioDepartamento_.departamento).get(Departamento_.id), departamento.getId()));
		predicates.add(builder.isTrue(root.get(FuncionarioDepartamento_.ATUAL)));
		criteria.where(predicates.toArray(new Predicate[predicates.size()]));
		
		TypedQuery<Funcionario> query = entityManager.createQuery(criteria);
	
		
		return query.getResultList();
	}

}
