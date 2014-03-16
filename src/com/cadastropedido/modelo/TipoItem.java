package com.cadastropedido.modelo;

public class TipoItem {
	private int id;
	private String nome;
	
	public final TipoItem PRODUTO = new TipoItem(1, "Produto");
	public final TipoItem SERVICO = new TipoItem(2, "Serviço");
	
	public TipoItem() {

	}
	
	public TipoItem(int id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}
	
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
	
	
}
