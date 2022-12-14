package br.com.biblioteca.models;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;

	@NotEmpty(message = "Preencha o nome")
	private String nome;

	@NotEmpty
	private int senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	private List<Emprestimo> historico;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public List<Emprestimo> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Emprestimo> historico) {
		this.historico = historico;
	}
}
