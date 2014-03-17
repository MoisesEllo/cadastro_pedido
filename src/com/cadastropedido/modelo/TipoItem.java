package com.cadastropedido.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="tipo_item")
public class TipoItem  implements Serializable{
	
	@Id
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	public static final TipoItem PRODUTO = new TipoItem(1, "Produto");
	public static final TipoItem SERVICO = new TipoItem(2, "Serviço");
	
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
