package br.com.amazonia.model;

import java.util.List;

import br.com.amazonia.persistence.CupomDAO;

public class Cupom {
	private String nomeCupom;
	private InfoProduto produtoCupom;
	private int valorCupom;
	private String periodoCupom;

	public Cupom() {
		super();
	}

	public Cupom(String nomeCupom, InfoProduto produtoCupom, int valorCupom, String periodoCupom) {
		super();
		this.nomeCupom = nomeCupom;
		this.produtoCupom = produtoCupom;
		this.valorCupom = valorCupom;
		this.periodoCupom = periodoCupom;
	}

	public String getNomeCupom() {
		return nomeCupom;
	}

	public void setNomeCupom(String nomeCupom) {
		this.nomeCupom = nomeCupom;
	}

	public InfoProduto getProdutoCupom() {
		return produtoCupom;
	}

	public void setProdutoCupom(InfoProduto produtoCupom) {
		this.produtoCupom = produtoCupom;
	}

	public int getValorCupom() {
		return valorCupom;
	}

	public void setValorCupom(int valorCupom) {
		this.valorCupom = valorCupom;
	}

	public String getPeriodoCupom() {
		return periodoCupom;
	}

	public void setPeriodoCupom(String periodoCupom) {
		this.periodoCupom = periodoCupom;
	}

	public void confirmaCupom(List<Carrinho> carrinho, String c) {
		// Encaminha para uma busca no que seria o BD para verificar se o cupom existe
		CupomDAO cupom = new CupomDAO();
		List<Cupom> produtoCupom = cupom.buscaDesconto(c);
		// Ap�s retorno da busca, faz uma valida��o se foi encontrado ou n�o
		if (produtoCupom == null || produtoCupom.isEmpty()) {
			System.out.println("Cupom inexistente!");
		} else {
			// Inserindo ent�o o desconto no produto espec�fico
			for (Cupom p : produtoCupom) {
				for (Carrinho ca : carrinho) {
					if (p.getProdutoCupom().getNomeProduto()
							.equals(ca.getProdutos().getItemProduto().getNomeProduto())) {
						ca.getProdutos().getItemProduto()
								.setValor(ca.getProdutos().getItemProduto().getValor() - p.getValorCupom());
						System.out.println("Produto: " + ca.getProdutos().getItemProduto().getNomeProduto());
						System.out.println("Valor do cupom: " + p.valorCupom);
					}
				}
			}
		}
	}
}