package com.cadastropedido.model;

public class Item {
	
	private int id;
	private String nome;
	private String descricao;
	private TipoItem tipo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoItem getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoItem tipo) {
		this.tipo = tipo;
	}
	
	
}
