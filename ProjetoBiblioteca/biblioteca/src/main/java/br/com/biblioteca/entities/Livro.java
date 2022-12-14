package br.com.biblioteca.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "livro")
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String autor;
	private String ano;
	private boolean status;
	
	
	private int genero;
	
	@OneToOne
	@JoinColumn(name="emprestimo_id")
	private Emprestimo emprestimo;
	
	
	public Livro(){}
	
	public Livro(Long id, String nome, String autor, String ano, boolean status, Genero genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
		this.status = status;
		setGenero(genero);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Genero getGenero() {
		return Genero.valueOf(genero);
	}
	public void setGenero(Genero genero) {
		if(genero != null)
			this.genero = genero.getCodigo();
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
