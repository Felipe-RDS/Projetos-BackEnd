package br.com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
