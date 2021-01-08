package br.com.projeto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;
import br.com.projeto.model.FuncionarioDepartamento;
import br.com.projeto.repository.departamento.DepartamentoRepository;
import br.com.projeto.repository.funcionarioDepartamento.FuncionarioDepartamentoRepository;

@Service
public class FuncionarioDepartamentoService {

	@Autowired
	private FuncionarioDepartamentoRepository funcionarioDepartamentoRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	public FuncionarioDepartamento salvar(FuncionarioDepartamento funcionarioDepartamento) {

		Optional<FuncionarioDepartamento> funcionarioDepartamentoSalvo = buscarPorFuncionarioEDepartamento(funcionarioDepartamento);

		if (funcionarioDepartamentoSalvo.isPresent()) {
			return funcionarioDepartamentoSalvo.get();
		} else {
			atulizaStatus(funcionarioDepartamento.getFuncionario());
			funcionarioDepartamento.setAtual(true);
			return funcionarioDepartamentoRepository.save(funcionarioDepartamento);
		}

	}

	private Optional<FuncionarioDepartamento> buscarPorFuncionarioEDepartamento(FuncionarioDepartamento funcionarioDepartamento) {
		Optional<FuncionarioDepartamento> funcionarioDepartamentoSalvo = funcionarioDepartamentoRepository
				.findByFuncionarioAndDepartamento(funcionarioDepartamento.getFuncionario(),
						funcionarioDepartamento.getDepartamento());
		return funcionarioDepartamentoSalvo;
	}

	private void atulizaStatus(Funcionario funcionario) {
		List<FuncionarioDepartamento> funcionarioDepartamentos = funcionarioDepartamentoRepository
				.findByFuncionario(funcionario);
		for (FuncionarioDepartamento funcionarioDepartamento : funcionarioDepartamentos) {
			funcionarioDepartamento.setAtual(false);
		}
		funcionarioDepartamentoRepository.saveAll(funcionarioDepartamentos);

	}
	
	public List<Funcionario> listarFuncionarioPorDeparmento(String departamento){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Optional<Departamento> departamentoSalvo = departamentoRepository.findByDepartamentoName(departamento);
		
		if (departamentoSalvo.isPresent()) {
			funcionarios = funcionarioDepartamentoRepository.listarFuncionarioPorDepardamento(departamentoSalvo.get());
		}
		return funcionarios;
	}

}
