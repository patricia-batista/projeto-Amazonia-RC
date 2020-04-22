package br.com.amazonia.model;

import br.com.amazonia.service.CorreioWebSerice;

public class Correio {
	private double frete = 0;
	
	public double confirmaFrete(Cliente cliente, String codigoServico) {
		CorreioWebSerice servicoCorreio = new CorreioWebSerice();
		int indice = 0;
		//Verificação do formato do produto: mídia digital ou físico
		for (Carrinho produto : cliente.getCarrinho()) {
			if(produto.getProdutos().getFormatoProduto().equalsIgnoreCase("Físico")) { 
				frete += servicoCorreio.valorFrete(cliente, codigoServico, indice);
				//Se cliente optou por produto "físico", será cobrado o frete
			}
			indice++;
		}
		return frete;
	}

}