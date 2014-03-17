package com.cadastropedido.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="item_pedido")
public class ItemPedido implements Serializable{
	
	@EmbeddedId
	private ItemPedidoPK itemPedidoPK;

	@Column(name = "quantidade", nullable = true)
	private Double quantidade;
	
	public ItemPedido() {
		itemPedidoPK = new ItemPedidoPK();
	}
	
	public Pedido getPedido() {
		return itemPedidoPK.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		itemPedidoPK.setPedido(pedido);
	}
	
	public Item getItem() {
		return itemPedidoPK.getItem();
	}
	
	public void setItem(Item item) {
		this.itemPedidoPK.setItem(item);
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	public ItemPedidoPK getItemPedidoPK() {
		return itemPedidoPK;
	}

	public void setItemPedidoPK(ItemPedidoPK itemPedidoPK) {
		this.itemPedidoPK = itemPedidoPK;
	}
}
