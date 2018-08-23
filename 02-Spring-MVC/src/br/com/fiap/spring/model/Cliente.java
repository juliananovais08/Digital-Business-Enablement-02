package br.com.fiap.spring.model;

public class Cliente {

	private String nome;
	
	private int idade;
	
	private boolean cnh;
	
	private String genero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isCnh() {
		return cnh;
	}

	public void setCnh(boolean cnh) {
		this.cnh = cnh;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
