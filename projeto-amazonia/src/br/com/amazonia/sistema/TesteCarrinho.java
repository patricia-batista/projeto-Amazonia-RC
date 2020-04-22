package br.com.amazonia.sistema;

import java.util.Arrays;
import java.util.List;

import br.com.amazonia.model.Carrinho;
import br.com.amazonia.model.InfoProduto;
import br.com.amazonia.model.ProdutoCarrinho;

public class TesteCarrinho {

	public static void main(String[] args) {
	
		//Dados do carrinho do cliente
		List<Carrinho> dadosCarrinho = novoCarrinho();
		Carrinho carrinho = new Carrinho();
		
		System.out.println("Carrinho de Compras");		
		carrinho.listaProdutos(dadosCarrinho); //listagem de todos os produtos no carrinho		
		System.out.println("valor Total: R$ " + carrinho.somaValorTotal(dadosCarrinho)); //valor total sem cupom, impostos e frete
		
	}
	
	private static List<Carrinho> novoCarrinho() {
		InfoProduto livro1 = new InfoProduto("Alice no País das Maravilhas", "Fantasia", "Livro", 60, "Ambos", "0.50");
		InfoProduto livro2 = new InfoProduto("O Rei do Inverno", "Ficção Histórica", "e-Reader", 40, "Digital", "0");
		ProdutoCarrinho prod1 = new ProdutoCarrinho(livro1, 1, "Digital");
		ProdutoCarrinho prod2 = new ProdutoCarrinho(livro2, 1, "Físico");
		
		Carrinho produto1 = new Carrinho(prod1);
		Carrinho produto2 = new Carrinho(prod2);
		
		List<Carrinho> carrinho = Arrays.asList(produto1, produto2);
		
		return carrinho;
	}

}