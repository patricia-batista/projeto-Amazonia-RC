package br.com.amazonia.model;

import br.com.amazonia.service.CorreioWebSerice;

public class Correio {
	private double frete = 0;
	
	public double confirmaFrete(Cliente cliente, String codigoServico) {
		CorreioWebSerice servicoCorreio = new CorreioWebSerice();
		int indice = 0;
		//Verifica��o do formato do produto: m�dia digital ou f�sico
		for (Carrinho produto : cliente.getCarrinho()) {
			if(produto.getProdutos().getFormatoProduto().equalsIgnoreCase("F�sico")) { 
				frete += servicoCorreio.valorFrete(cliente, codigoServico, indice);
				//Se cliente optou por produto "f�sico", ser� cobrado o frete
			}
			indice++;
		}
		return frete;
	}

}