package br.com.amazonia.model;

public class ProdutoCarrinho {

	private InfoProduto itemProduto;
	private int qtdeProduto;
	private String formatoProduto;
	
	public ProdutoCarrinho(InfoProduto itemProduto, int qtdeProduto, String formatoProduto) {
		super();
		this.itemProduto = itemProduto;
		this.qtdeProduto = qtdeProduto;
		this.formatoProduto = formatoProduto;
	}

	public InfoProduto getItemProduto() {
		return itemProduto;
	}

	public void setItemProduto(InfoProduto itemProduto) {
		this.itemProduto = itemProduto;
	}

	public int getQtdeProduto() {
		return qtdeProduto;
	}

	public void setQtdeProduto(int qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}

	public String getFormatoProduto() {
		return formatoProduto;
	}

	public void setFormatoProduto(String formatoProduto) {
		this.formatoProduto = formatoProduto;
	}
	
}
