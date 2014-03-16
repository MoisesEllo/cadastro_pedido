package com.cadastropedido.web;

public class RespostaRequisicao 
{
	private String mensagemErro;
	private String resposta;
	
	public String getMensagem() {
		return mensagemErro;
	}
	
	public void setMensagem(String msg) {
		this.mensagemErro = msg;
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
