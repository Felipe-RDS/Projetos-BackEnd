package br.com.biblioteca.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.biblioteca.entities.Livro;
import br.com.biblioteca.repositories.LivroRepository;

@Controller
@RequestMapping("/")
public class LivroController {
	@Autowired
	private LivroRepository repository;
	
	@GetMapping
	public List<Livro> findAll(){
		List<Livro>resposta = repository.findAll();
		return resposta;
	}
	
	@GetMapping(value = "/{id}")
	public Livro findById(@PathVariable Long id){
		Livro resposta = repository.findById(id).get();
		return resposta;
	}
	
	
	@PostMapping
	public Livro addLivro(@RequestBody Livro Livro) {
		Livro resposta = repository.save(Livro);
		return resposta;
	}
}

