package com.cadastropedido.banco;

import java.util.List;

import javax.persistence.EntityManager;

import com.cadastropedido.modelo.Item;

public class ItemBanco extends Banco{
	
	public ItemBanco() {
		super();
	}
	
	public List<Item> obterTodos()
	{
		EntityManager manager = factory.createEntityManager();
		
		try {
			
			return manager.createQuery("SELECT i FROM Item i ORDER BY i.nome").getResultList(); 
			
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
