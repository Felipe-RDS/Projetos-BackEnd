package br.com.biblioteca.entities;

public enum Genero {
	TERROR(1), 
	SUSPENSE(2), 
	DIDATICO(3);
	
	private int codigo;
	
	private Genero(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static Genero valueOf(int codigo) {
		for(Genero value : Genero.values()) {
			if(codigo == value.getCodigo())
				return value;
		}
		throw new IllegalArgumentException("Codigo de genero invalido");
	}
}
