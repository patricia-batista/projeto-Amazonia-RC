package br.com.amazonia.sistema;

import java.util.Arrays;
import java.util.List;

import br.com.amazonia.controller.Checkout;
import br.com.amazonia.model.*;

public class TesteCheckout {

	public static void main(String[] args) {
		List<Carrinho> carrinho = novoCarrinho(); // produtos inseridos no carrinho
		Cliente cliente = novoCliente(carrinho); // informações sobre o cliente
		/*
		 * Visitante visitante = new Visitante(); Serviria para distiguir tipo de
		 * acesso: se cliente já cadastrado, seguiria para próxima etapa da compra
		 */
		Checkout usuario = new Checkout();
		// Confirmação automática de usuário logado
		usuario.confirmaLogin(cliente);
		System.out.println("\t\t\t***");
		/*
		 * usuario.confirmaLogin(visitante); Com isso, seria possível contabilizar itens
		 * adquiridos como visitante + itens adquiridos como cliente cadastrado
		 */

		// Confirmação de Desconto do Produto (Cliente digita via tela o desconto desejado)
		String cupom = "10conto";
		Cupom c = new Cupom();
		System.out.println("Cupom adicionado: " + cupom + "\nProduto (s) com desconto: ");
		c.confirmaCupom(cliente.getCarrinho(), cupom);
		System.out.println("\t\t\t***");

		// Confirmação do Frete (Cliente poderia utilizar endereço já cadastrado ou alterar)
		String codigoServico = "40606"; // Forma de entrega
		System.out.println("Frete: " + usuario.aplicaFrete(cliente, codigoServico));

		// Confirmação automática de Imposto sobre produtos
		usuario.calculaImposto(cliente.getCarrinho());
		System.out.println("\t\t\t***");

		/*Antes de prosseguir: necessário a inserção de um e-mail e senha do GMail na classe "JavaMail":
		 *"seu-email-aqui@gmail.com", "sua-senha-aqui"*/
		System.out.println("Finalização da compra\nLista de Produtos:");
		String formaPagamento = "boleto";
		usuario.finalizaPedido(cliente, formaPagamento);

	}

	private static List<Carrinho> novoCarrinho() {
		InfoProduto livro1 = new InfoProduto("Alice no País das Maravilhas", "Fantasia", "Livro", 60, "Ambos", "0.50");
		InfoProduto livro2 = new InfoProduto("O Rei do Inverno", "Ficção Histórica", "eReader", 40, "Digital", "0");
		InfoProduto jogo = new InfoProduto("Kingdom Hearts All-In-One Package", "Game - Combo Disney", "Jogo", 115.15,
				"Ambos", "0.10");
		InfoProduto serie = new InfoProduto("Box Breaking Bad", "Série", "Serie", 70, "Ambos", "0.30");

		ProdutoCarrinho prod1 = new ProdutoCarrinho(livro1, 1, "Físico");
		ProdutoCarrinho prod2 = new ProdutoCarrinho(livro2, 1, "Digital");
		ProdutoCarrinho prod3 = new ProdutoCarrinho(jogo, 1, "Físico");
		ProdutoCarrinho prod4 = new ProdutoCarrinho(serie, 1, "Digital");

		Carrinho produto1 = new Carrinho(prod1);
		Carrinho produto2 = new Carrinho(prod2);
		Carrinho produto3 = new Carrinho(prod3);
		Carrinho produto4 = new Carrinho(prod4);

		List<Carrinho> carrinho = Arrays.asList(produto1, produto2, produto3, produto4);

		return carrinho;
	}

	private static Cliente novoCliente(List<Carrinho> carrinho) {
		Endereco endereco = new Endereco("Rua Teffé", 215, "Santa Maria", "Casa 2", "09560140", "São Paulo", "SP",
				"Brasil");
		Cadastro cadastro = new Cadastro("123456789-00", "Patricia", endereco, "patricia.b.morais@hotmail.com",
				"senha123");

		Cliente cliente = new Cliente(carrinho, cadastro);

		return cliente;
	}

}