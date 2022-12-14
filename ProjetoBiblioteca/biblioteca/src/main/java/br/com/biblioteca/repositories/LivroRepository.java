package br.com.biblioteca.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
