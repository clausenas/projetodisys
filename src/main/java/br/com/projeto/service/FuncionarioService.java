package br.com.projeto.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.dto.FuncionarioDTO;
import br.com.projeto.model.Cargo;
import br.com.projeto.model.Departamento;
import br.com.projeto.model.Funcionario;
import br.com.projeto.model.FuncionarioDepartamento;
import br.com.projeto.repository.cargo.CargoRepository;
import br.com.projeto.repository.funcionario.FuncionarioRepository;
import br.com.projeto.service.exception.RecursoInexistenteException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private FuncionarioDepartamentoService funcionarioDepartamentoService;

	@Transactional
	public FuncionarioDTO incluir(FuncionarioDTO funcionarioDTO) {
		funcionarioDTO.setFuncionario(salvar(funcionarioDTO.getFuncionario()));
		funcionarioDTO.setDepartamento(adicionarDepartamento(funcionarioDTO.getDepartamento()));
		adicionarFuncionarioDepartamento(funcionarioDTO.getDepartamento(), funcionarioDTO.getFuncionario());
		return funcionarioDTO;
	}
	
	@Transactional
	public FuncionarioDTO atualizar(Long id, FuncionarioDTO funcionarioDTO) {
		funcionarioDTO.setFuncionario(atualizar(id, funcionarioDTO.getFuncionario()));
		funcionarioDTO.setDepartamento(adicionarDepartamento(funcionarioDTO.getDepartamento()));
		adicionarFuncionarioDepartamento(funcionarioDTO.getDepartamento(), funcionarioDTO.getFuncionario());
		return funcionarioDTO;
		
	}
	
	
	private Funcionario salvar(Funcionario funcionario) {
		funcionario.setCargo(retornaCargoPorNome(funcionario.getCargo()));
		funcionarioRepository.save(funcionario);
		return funcionarioRepository.save(funcionario);

	}

	public Funcionario atualizar(Long id, Funcionario funcionario) {
		Funcionario funcionarioSalvo = buscarFuncionarioExistente(id);
		BeanUtils.copyProperties(funcionario, funcionarioSalvo, "id");
		return funcionarioRepository.save(funcionarioSalvo);
	}

	public Funcionario buscarFuncionarioExistente(Long id) {

		Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(id);
		if (!funcionarioSalvo.isPresent()) {
			throw new RecursoInexistenteException("Funcionario não Encontrado");
		}
		return funcionarioSalvo.get();

	}

	private Cargo retornaCargoPorNome(Cargo cargo) {
		Optional<Cargo> cargoSalvo = cargoRepository.findByCargoNome(cargo.getCargoNome());
		return cargoSalvo.isPresent() ? cargoSalvo.get() : cargo;

	}
	
	
	private Departamento adicionarDepartamento(Departamento departamento) {
		return departamentoService.salvar(departamento);
		
	}
	
	private void adicionarFuncionarioDepartamento(Departamento departamento, Funcionario funcionario) {
		FuncionarioDepartamento funcionarioDepartamento = new FuncionarioDepartamento(departamento, funcionario);
		funcionarioDepartamentoService.salvar(funcionarioDepartamento);
		
	}
	
	
	

}
