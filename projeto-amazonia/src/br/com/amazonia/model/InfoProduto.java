package br.com.amazonia.model;


public class InfoProduto {
	private String nomeProduto;
	private String descricao;
	private String tipoProduto;
	private double valor;
	private String formatoProduto;
	private String pesoProduto;

	public InfoProduto() {
		super();
	}

	public InfoProduto(String nomeProduto, String descricao, String tipoProduto, double valor, String formatoProduto,
			String pesoProduto) {
		super();
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.tipoProduto = tipoProduto;
		this.valor = valor;
		this.formatoProduto = formatoProduto;
		this.pesoProduto = pesoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipoProduto() {
		return tipoProduto;
	}
	
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getFormatoProduto() {
		return formatoProduto;
	}
	
	public void setFormatoProduto(String formatoProduto) {
		this.formatoProduto = formatoProduto;
	}
	
	public String getPesoProduto() {
		return pesoProduto;
	}
	
	public void setPesoProduto(String pesoProduto) {
		this.pesoProduto = pesoProduto;
	}
		
}
