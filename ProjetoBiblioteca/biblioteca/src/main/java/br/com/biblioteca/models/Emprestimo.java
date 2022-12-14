package br.com.biblioteca.models;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;


public class Emprestimo {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(unique = true)
	private int codigo;
	
	@NotEmpty
	private Date dataInicio;
	
	@NotEmpty
	private Date dataDevolucao;
	
	@NotEmpty
	private boolean status;
	
	@NotEmpty
	@ManyToOne
	private Usuario usuario;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
