package br.com.amazonia.test;

import java.util.Arrays;

import java.util.List;

import org.junit.Test;

import br.com.amazonia.controller.Checkout;
import br.com.amazonia.model.*;

public class CupomTeste {
	
	InfoProduto produto1 = new InfoProduto("Alice no País das Maravilhas", "Fantasia", "Livro", 60, "Ambos", "0.50");
	InfoProduto produto2 = new InfoProduto("O Rei do Inverno", "Ficção Histórica", "e-Reader", 40, "Digital", "0");
	InfoProduto produto3 = new InfoProduto("Kingdom Hearts All-In-One Package", "Game - Combo Disney", "Jogo", 115.15, "Ambos", "0.10");
	InfoProduto produto4 = new InfoProduto("Box Breaking Bad", "Série", "Serie", 70, "Ambos", "0.30");
	
	ProdutoCarrinho prod1 = new ProdutoCarrinho(produto1, 1, "Físico");
	ProdutoCarrinho prod2 = new ProdutoCarrinho(produto2, 1, "Digital");
	ProdutoCarrinho prod3 = new ProdutoCarrinho(produto3, 1, "Físico");
	ProdutoCarrinho prod4 = new ProdutoCarrinho(produto4, 1, "Digital");
	
	Carrinho c1 = new Carrinho(prod1);
	Carrinho c2 = new Carrinho(prod2);
	Carrinho c3 = new Carrinho(prod3);
	Carrinho c4 = new Carrinho(prod4);
	
	//Adicione ou remova os produtos do carrinho
	List<Carrinho> carrinho = Arrays.asList(c1, c2, c3, c4);
	
	Endereco endereco = new Endereco("Rua Teffé", 215, "Santa Maria", "Casa 2", "09560140",
				"São Paulo", "SP", "Brasil");
	Cadastro cadastro = new Cadastro("123456789-00", "Patricia", endereco, "patricia.b.morais@hotmail.com", "senha123");

	Cliente cliente = new Cliente(carrinho, cadastro);
	
	Checkout usuario = new Checkout();
	
	@Test
	public void deveImprimirCupom() {
		//Insira um cupom para validá-lo:
		String cupom = "10conto";
		Cupom c = new Cupom();
		c.confirmaCupom(carrinho, cupom);
		
		/* Cupons inseridos na camada DAO 
		 * Cupom cupom1 = new Cupom("10conto", produto1, 10, "10/05/2020");
		 * Cupom cupom2 = new Cupom("10conto", produto2, 5, "01/05/2020");*/
	}
	
}
