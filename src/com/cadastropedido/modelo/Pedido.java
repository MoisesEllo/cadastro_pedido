package com.cadastropedido.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido  implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "data", nullable = false)
	private Calendar data;
	
	@Column(name = "nome_cliente", nullable = false)
	private String nomeCliente;
	
	public Pedido() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
