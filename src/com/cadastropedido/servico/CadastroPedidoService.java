package com.cadastropedido.servico;

import java.util.Calendar;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.cadastropedido.banco.ItemBanco;
import com.cadastropedido.banco.ItemPedidoBanco;
import com.cadastropedido.modelo.Item;
import com.cadastropedido.modelo.ItemPedido;
import com.cadastropedido.modelo.Pedido;

public class CadastroPedidoService {
	
	public List<Item> obterItems() {
		
		ItemBanco banco = new ItemBanco();
		
		return banco.obterTodos();
	}
	
	public Pedido salvarPedido(String nomeCliente, List<ItemPedido> items) {
		
		Pedido novoPedido = new Pedido();
		
		novoPedido.setNomeCliente(nomeCliente);
		novoPedido.setData(Calendar.getInstance());
		
		ItemPedidoBanco banco = new ItemPedidoBanco();
		banco.salvar(items, novoPedido);
		
		return novoPedido;
	}
}
