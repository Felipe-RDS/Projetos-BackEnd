package br.com.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.entities.Usuario;
import br.com.biblioteca.repositories.UserRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<Usuario> findAll(){
		List<Usuario>resposta = repository.findAll();
		return resposta;
	}
	
	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable Long id){
		Usuario resposta = repository.findById(id).get();
		return resposta;
	}
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		Usuario resposta = repository.save(usuario);
		return resposta;
	}
}
