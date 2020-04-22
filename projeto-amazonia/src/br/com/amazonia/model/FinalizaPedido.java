package br.com.amazonia.model;

public class FinalizaPedido {
	private double valorTotal;
	private JavaMail compraFinalizada = new JavaMail();

	public void finalizaPedido(Cliente cliente, String formaPagamento) {
		int i = 1;
		for (Carrinho produtos : cliente.carrinho) {
			System.out.println(i + ") " + produtos.getProdutos().getItemProduto().getNomeProduto() + " - R$ "
					+ produtos.getProdutos().getItemProduto().getValor() + "\nFormato do produto: "
					+ produtos.getProdutos().getFormatoProduto());
			valorTotal += produtos.getProdutos().getItemProduto().getValor();
			i++;
		}
		System.out.println(valorTotal);
		System.out.println("Forma de Pagamento: " +formaPagamento);
		compraFinalizada.confirmacaoEmail(cliente, valorTotal);
	}
}