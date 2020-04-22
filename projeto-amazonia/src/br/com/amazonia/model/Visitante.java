package br.com.amazonia.model;

import br.com.amazonia.controller.Usuario;

public class Visitante extends Usuario{
	boolean logado;

	public boolean isLogado() {
		return logado = false;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
}
