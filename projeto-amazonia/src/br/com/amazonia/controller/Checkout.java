package br.com.amazonia.controller;

import java.util.List;

import br.com.amazonia.model.Carrinho;
import br.com.amazonia.model.Cliente;
import br.com.amazonia.model.Correio;
import br.com.amazonia.model.Cupom;
import br.com.amazonia.model.FinalizaPedido;
import br.com.amazonia.model.Imposto;

public class Checkout {
	
	private Cupom cupom;
	private Correio correio;
	private Imposto imposto;
	private FinalizaPedido fechaPedido;
	
	public void confirmaLogin(Usuario usuario) {
		if(usuario.isLogado()) {
			//redirecionaria para a tela de compra
			System.out.println("Cliente já cadastrado... Pode prosseguir com a compra.");
		} else {
			//redirecionaria para tela de cadastro/login
			System.out.println("Visitante... Entre em sua conta ou faça um cadastro.");
		}
	}
	
	public double aplicaFrete(Cliente cliente, String codigoServico) {
		correio = new Correio();
		return correio.confirmaFrete(cliente, codigoServico);
	}

	public void aplicaCupom(List<Carrinho> carrinho, String c) {
		cupom = new Cupom();
		cupom.confirmaCupom(carrinho, c);	
	}
	
	public void calculaImposto(List<Carrinho> carrinho) {
		imposto = new Imposto();
		imposto.aplicaImposto(carrinho);
	}
	
	public void finalizaPedido(Cliente cliente, String formaPagamento) {
		fechaPedido = new FinalizaPedido();
		fechaPedido.finalizaPedido(cliente, formaPagamento);
	}
}