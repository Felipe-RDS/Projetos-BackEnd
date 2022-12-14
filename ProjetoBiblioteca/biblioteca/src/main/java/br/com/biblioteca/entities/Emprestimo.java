package br.com.biblioteca.entities;

import java.time.Instant;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "emprestimo")
@Table(name = "emprestimo")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean status;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToOne
	private Livro livro;
	
	public Emprestimo(Long id, boolean status){
		this.id = id;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
