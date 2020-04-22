package br.com.amazonia.model;

import java.util.List;

import br.com.amazonia.controller.Usuario;

public class Cliente extends Usuario {
	
	private Cadastro cadastro;
	public Cliente() {
		super();
	}

	public Cliente(List<Carrinho> carrinho, Cadastro cadastro) {
		super(carrinho);
		this.cadastro = cadastro;
	}
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public boolean isLogado() {
		return true;
	}
}
