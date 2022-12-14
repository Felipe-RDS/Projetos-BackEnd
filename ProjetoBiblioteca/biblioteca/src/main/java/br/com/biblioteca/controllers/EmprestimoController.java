package br.com.biblioteca.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.biblioteca.entities.Emprestimo;
import br.com.biblioteca.repositories.EmprestimoRepository;

@Controller
public class EmprestimoController {
	
	private EmprestimoRepository repository;
	
	@PostMapping
	public List<Emprestimo> findAll(){
		List<Emprestimo>resposta = repository.findAll();
		return resposta;
	}
	
}
