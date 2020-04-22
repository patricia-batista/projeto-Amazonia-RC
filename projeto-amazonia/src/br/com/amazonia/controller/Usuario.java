package br.com.amazonia.controller;


import java.util.List;

import br.com.amazonia.model.Carrinho;

public class Usuario {
	
	public List<Carrinho> carrinho;
	private boolean logado;
	
	public Usuario() {
		super();
	}

	public Usuario(List<Carrinho> carrinho) {
		super();
		this.carrinho = carrinho;
	}

	public List<Carrinho> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
}
