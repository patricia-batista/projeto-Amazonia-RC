package br.com.amazonia.model;

import java.util.List;

public class Imposto {
	
	private double imposto = 0;

	public void aplicaImposto(List<Carrinho> carrinho) {
		for (Carrinho produtos : carrinho) {
			if (produtos.getProdutos().getItemProduto().getTipoProduto().equalsIgnoreCase("livro")
					|| produtos.getProdutos().getItemProduto().getTipoProduto().equalsIgnoreCase("jornal")
					|| produtos.getProdutos().getItemProduto().getTipoProduto().equalsIgnoreCase("revista")
					|| produtos.getProdutos().getItemProduto().getTipoProduto().equalsIgnoreCase("ereader")) {
				System.out.println(produtos.getProdutos().getItemProduto().getNomeProduto()
						+ " - produto com isenção de imposto conforme disposto na Constituição Art. 150, VI, d.");
			} else {
				imposto = produtos.getProdutos().getItemProduto().getValor() * 0.1;
				produtos.getProdutos().getItemProduto()
						.setValor((produtos.getProdutos().getItemProduto().getValor() + imposto));
				System.out.println(produtos.getProdutos().getItemProduto().getNomeProduto() + " - produto com imposto: "
						+ produtos.getProdutos().getItemProduto().getValor());
			}
		}
	}
}