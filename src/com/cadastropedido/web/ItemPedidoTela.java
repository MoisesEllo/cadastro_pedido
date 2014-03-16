package com.cadastropedido.web;

public class ItemPedidoTela {
	private int id;
	private double quantidade;
	private String nome;
	
	public int getId() {
		return id;
	}
	
	public void setId(int idItem) {
		this.id = idItem;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
