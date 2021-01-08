package br.com.projeto.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.event.RecursoCriadoEvent;
import br.com.projeto.model.Departamento;
import br.com.projeto.repository.departamento.DepartamentoRepository;
import br.com.projeto.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")

public class DepartamentoController {
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private DepartamentoService departamentoService;
	@GetMapping
	public List<Departamento> listar(){
		return departamentoRepository.findAll();
	}
	
	
	
	@PutMapping("/{idDepartamento}/{idFuncionario}")
	public ResponseEntity<Departamento> adicionarChefeDepartamento(@PathVariable Long idDepartamento, @PathVariable Long idFuncionario, HttpServletResponse response){
		Departamento departamento = departamentoService.adicionaChefeDeparmento(idDepartamento, idFuncionario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, departamento.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
		
	}
	

}
