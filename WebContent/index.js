$(document).ready(function() {
	$.items = [];

	$("#btnAdicionarItem").click(adicionarItem);
	$("#btnEnviarPedido").click(enviarPedido);
	
	obterProdutos();
});

function obterProdutos()
{
	$.post( "CadastroPedidoServlet", { acao:"OBTER_ITEMS" }, function( responseObj ) {

		if(responseObj.mensagemErro)
		{
			alert(responseObj.mensagemErro);
		}
		else
		{
			var items = jQuery.parseJSON(responseObj.resposta);

			for(var key in items) {
				$("#ddlItemPedido").append($('<option></option>').val(items[key].id).html(items[key].nome));
			}
		}
	},"json");
}

function adicionarItem()
{

	var quantidade = $("#txtQuantidade").val();
	
	if(quantidade == "")
	{
		quantidade = null;
	}

	var item = {
		id : $("#ddlItemPedido").val(),
		nome : $("#ddlItemPedido option:selected").text(),
		quantidade : quantidade
	};
	
	$.items[item.id] = item;
	
	carregaTabelaPedidos();
}

function carregaTabelaPedidos()
{
	$("#tblItemsPedido > tbody").empty();
	
	for(var key in $.items)
	{
		var linha = document.createElement("tr");
		
		adicionaColuna(linha, $.items[key].nome); // Coluna item
		adicionaColuna(linha, $.items[key].quantidade); // Coluna quantidade
		adicionaColuna(linha, "<a href='#' onclick='javascript:excluirItemPedido("+ key +")'>Excluir</a>"); // Coluna opcoes
		
		$('#tblItemsPedido > tbody:last').append(linha);
	}
}

function adicionaColuna(linha, valor)
{
	var coluna = document.createElement("td");
	$(coluna).append(valor);
	$(linha).append(coluna);	
}

function enviarPedido()
{
	var nomeCliente = $("#txtNomeCliente").val();
	
	console.log({ acao:"SALVAR_PEDIDO", cliente: nomeCliente, items: JSON.stringify($.items) });
	
	$.post( "CadastroPedidoServlet", { acao:"SALVAR_PEDIDO", cliente: nomeCliente, items: JSON.stringify($.items) }, function( responseObj ) {

		if(responseObj.mensagemErro)
		{
			alert(responseObj.mensagemErro);
		}
		else
		{
			limparFormulario();
	
			alert('Pedido enviado com sucesso !');
		}
	},"json");
}

function limparFormulario()
{
	$("#txtNomeCliente").val("");
	$("#ddlItemPedido").val("");
	$("#txtQuantidade").val("");
	$("#tblItemsPedido > tbody").empty();
}

function excluirItemPedido(id)
{
	$.items.splice(id, 1);
	
	carregaTabelaPedidos();
}