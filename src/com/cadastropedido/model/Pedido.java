package com.cadastropedido.model;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Pedido {
	
	private int id;
	private Calendar data;
	private String nomeCliente;
	
	private List<ItemPedido> items;
	
	public Pedido() {
		items = new LinkedList<ItemPedido>();
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
	
	public void addItem(Item item, double quantidade)
	{
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPedido(this);
		itemPedido.setItem(item);
		itemPedido.setQuantidade(quantidade);
		
		items.add(itemPedido);
	}
	
}
