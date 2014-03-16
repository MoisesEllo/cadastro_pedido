$(document).ready(function() {
	$.items = [];

	$("#btnAdicionarItem").click(adicionarItem);
	$("#btnEnviarPedido").click(enviarPedido);
	
	obterProdutos();
});

function obterProdutos()
{
	var items = [
		{id: 1, nome: 'teste 1'},
		{id: 2, nome: 'teste 2'},
		{id: 3, nome: 'teste 3'},
		{id: 4, nome: 'teste 4'},
	];

	for(var key in items) {
		$("#ddlItemPedido").append($('<option></option>').val(items[key].id).html(items[key].nome));
	}
}

function adicionarItem()
{
	var item = {
		id : $("#ddlItemPedido").val(),
		nome : $("#ddlItemPedido option:selected").text(),
		quantidade : $("#txtQuantidade").val()
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
		
		adicionaColunaTexto(linha, $.items[key].nome); // Coluna item
		adicionaColunaTexto(linha, $.items[key].quantidade); // Coluna quantidade
		adicionaColunaTexto(linha, "<a href='#' onclick='javascript:excluirItemPedido("+ key +")'>Excluir</a>"); // Coluna opcoes
		
		$('#tblItemsPedido > tbody:last').append(linha);
	}
}

function adicionaColunaTexto(linha, valor)
{
	var coluna = document.createElement("td");
	$(coluna).append(valor);
	$(linha).append(coluna);	
}

function enviarPedido()
{
	var pedido = {
		cliente: $("#txtNomeCliente").val(),
		items: $.items
	};
	
	limparFormulario();
	
	alert('Pedido enviado com sucesso !');
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
	$.items.splice(id,1);
	
	carregaTabelaPedidos();
}