package com.cadastropedido.banco;

import java.util.List;

import javax.persistence.EntityManager;

import com.cadastropedido.modelo.ItemPedido;
import com.cadastropedido.modelo.Pedido;

public class ItemPedidoBanco extends Banco{
	
	public ItemPedidoBanco() {
		super();
	}
	
	public void salvar(List<ItemPedido> items, Pedido pedido)
	{
		EntityManager manager = factory.createEntityManager();
		
		try {
			
			manager.getTransaction().begin();
			
			manager.persist(pedido);

			for (ItemPedido itemPedido : items) {
				
				itemPedido.setPedido(pedido);
				
				manager.persist(itemPedido);
			}
			
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}
		finally
		{
			manager.close();
		}
	}
}
