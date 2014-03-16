package com.cadastropedido.modelo;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Pedido {
	
	private int id;
	private Calendar data;
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
