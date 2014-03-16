package com.cadastropedido.banco;

import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.cadastropedido.modelo.ItemPedido;
import com.cadastropedido.modelo.Pedido;

public class ItemPedidoBanco {
	
	public ItemPedidoBanco() {
		// TODO Auto-generated constructor stub
	}
	
	public void salvar(List<ItemPedido> items, Pedido pedido)
	{
		for (ItemPedido itemPedido : items) {
			itemPedido.setPedido(pedido);
		}
		
		throw new NotImplementedException();
	}
}
