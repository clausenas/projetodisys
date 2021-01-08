package br.com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.Funcionario;
import br.com.projeto.service.FuncionarioDepartamentoService;

@RestController
@RequestMapping("/funcionarioDeparmento")
public class FuncionarioDepartamentoController {
	
	@Autowired
	private FuncionarioDepartamentoService funcionarioDepartamentoService;
	
	@GetMapping("/{departamento}")
	private List<Funcionario> listarFuncionarioPorDeparmento(@PathVariable String departamento){
		return funcionarioDepartamentoService.listarFuncionarioPorDeparmento(departamento);
	}

}
