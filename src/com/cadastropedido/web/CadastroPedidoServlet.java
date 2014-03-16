package com.cadastropedido.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cadastropedido.modelo.Item;
import com.cadastropedido.modelo.ItemPedido;
import com.cadastropedido.modelo.Pedido;
import com.cadastropedido.servico.CadastroPedidoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class CadastroPedidoServlet
 */
@WebServlet("/CadastroPedidoServlet")
public class CadastroPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doRequest(request, response);
	}
	
	public enum Acoes {
		OBTER_ITEMS, SALVAR_PEDIDO, ACAO_INCORRETA
	};

	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		Acoes acao = null;
		
		try 
		{
			acao = Acoes.valueOf(request.getParameter("acao"));
		} 
		catch (Exception e) 
		{
			acao = Acoes.ACAO_INCORRETA;
		}
		
		CadastroPedidoService servico = new CadastroPedidoService();
		
		Gson jsonBuilder = new Gson();
		
		RespostaRequisicao requestResponse = new RespostaRequisicao();
		
		try {
			
			switch (acao) 
			{
				case OBTER_ITEMS:
				
					List<Item> items = servico.obterItems();
					
					requestResponse.setResposta(jsonBuilder.toJson(items));
					
					break;
					
				case SALVAR_PEDIDO:
					
					String nomeCliente = "";				
					
					try 
					{
						nomeCliente = request.getParameter("cliente");
					} 
					catch (Exception e) 
					{
						throw new RuntimeException("Parametro 'cliente' incorreto");
					}
					
					ItemPedidoTela[] itemsTela = null;				
					
					try 
					{
						itemsTela = jsonBuilder.fromJson(request.getParameter("items"), ItemPedidoTela[].class);
					} 
					catch (Exception e) 
					{
						throw new RuntimeException("Parametro 'cliente' incorreto");
					}
					
					List<ItemPedido> itemsPedido = new LinkedList<ItemPedido>();
					
					ItemPedido itemPedido = null;
					Item item = null;
					
					for (ItemPedidoTela itemTela : itemsTela) {
						
						itemPedido = new ItemPedido();
						
						item = new Item();
						item.setId(itemTela.getId());
						item.setNome(itemTela.getNome());
						itemPedido.setItem(item);
						
						itemPedido.setQuantidade(itemTela.getQuantidade());
						
						itemsPedido.add(itemPedido);
					}
					
					Pedido pedido = servico.salvarPedido(nomeCliente, itemsPedido);
					
					requestResponse.setResposta(jsonBuilder.toJson(pedido));
					
					break;
					
				default:
					
					requestResponse.setMensagem("Ação inesperada !!");
			}
			
		} catch (Exception e) {
			requestResponse.setMensagem("Erro tratando requisição, por favor contate o administrador.");
		}
		
		out.write(jsonBuilder.toJson(requestResponse));
	}
}
