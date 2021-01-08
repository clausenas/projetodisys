package br.com.projeto.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;
import br.com.projeto.repository.departamento.DepartamentoRepository;
import br.com.projeto.service.exception.RecursoInexistenteException;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	public Departamento salvar(Departamento departamento) {
		Optional<Departamento> deparOptionalSalvo = departamentoRepository.findByDepartamentoName(departamento.getDepartamentoName());
		if (deparOptionalSalvo.isPresent()) {
			return atualizar(departamento);
		}else {
			return departamentoRepository.save(departamento);
		}
	}
	
	private Departamento atualizar(Departamento departamento) {
		Departamento deparOptionalSalvo = RetornaDepartamentoPorNome(departamento);
		BeanUtils.copyProperties(departamento, deparOptionalSalvo, "id");
		return departamentoRepository.save(deparOptionalSalvo);
		
	}
	
	public Departamento adicionaChefeDeparmento(Long idDepartamento, Long idFuncionario) {
		Funcionario funcionario = funcionarioService.buscarFuncionarioExistente(idFuncionario);
		Departamento departamento = buscarDepartamentoExistente(idDepartamento);
		departamento.setChefeDeparmento(funcionario);
		return departamentoRepository.save(departamento);
	}
	
	private Departamento RetornaDepartamentoPorNome(Departamento departamento) {
		Optional<Departamento> deparOptionalSalvo = departamentoRepository.findByDepartamentoName(departamento.getDepartamentoName());
		return deparOptionalSalvo.isPresent() ? deparOptionalSalvo.get() : departamento;
		
	}
	
	
	private Departamento buscarDepartamentoExistente(Long id) {
		Optional<Departamento> departamentoSalvo = departamentoRepository.findById(id);
		
		if (!departamentoSalvo.isPresent()) {
			throw new RecursoInexistenteException("Departamento não Encontrado");
		}
		
		return departamentoSalvo.get();
		
	}

}
