package com.cadastropedido.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "descricao", nullable = true)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_item")
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
