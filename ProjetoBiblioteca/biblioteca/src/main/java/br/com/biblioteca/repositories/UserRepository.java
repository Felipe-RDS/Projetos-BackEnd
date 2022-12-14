package br.com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.biblioteca.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "select * from usuario where email = :email and senha = :senha", nativeQuery = true)
	public Usuario Login(String email, int senha);
}
