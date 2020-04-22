package br.com.amazonia.model;

import java.util.List;

public class Carrinho {
		
	private ProdutoCarrinho produtos;
	private double valorTotal;
	
	public Carrinho() {
		super();
	}

	public Carrinho(ProdutoCarrinho produtos) {
		super();
		this.produtos = produtos;
	}

	public ProdutoCarrinho getProdutos() {
		return produtos;
	}

	public void setProdutos(ProdutoCarrinho produtos) {
		this.produtos = produtos;
	}

	public void listaProdutos(List<Carrinho> carrinho) {
		for (Carrinho produto : carrinho) {
			System.out.println("Produto: " +produto.getProdutos().getItemProduto().getNomeProduto());
			System.out.println("Formato da mídia: " +produto.getProdutos().getFormatoProduto());
			System.out.println("Valor do Produto: R$ " +produto.getProdutos().getItemProduto().getValor());
		}
	}
	
	public double somaValorTotal(List<Carrinho> carrinho) {
		for (Carrinho produto : carrinho) {
			valorTotal += produto.getProdutos().getItemProduto().getValor();
		}

		return valorTotal;
	}
	
}