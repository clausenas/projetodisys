package br.com.projeto.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.dto.FuncionarioDTO;
import br.com.projeto.model.Funcionario;
import br.com.projeto.repository.funcionario.FuncionarioRepository;
import br.com.projeto.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	private List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> incluir(@Valid @RequestBody FuncionarioDTO funcionarioDTO, HttpServletResponse response){
		FuncionarioDTO dto = funcionarioService.incluir(funcionarioDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioDTO> atualizar(@Valid @PathVariable Long id, @RequestBody  FuncionarioDTO funcionarioDTO, HttpServletResponse response){
		try {
			FuncionarioDTO dto = funcionarioService.atualizar(id ,funcionarioDTO);
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario, HttpServletResponse response){
		try {
			Funcionario funcionarioSalvo = funcionarioService.atualizar(id ,funcionario);
			return ResponseEntity.ok(funcionarioSalvo);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);
	}
	

}
