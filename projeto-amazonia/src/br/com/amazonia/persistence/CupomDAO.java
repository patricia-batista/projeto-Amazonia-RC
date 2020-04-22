package br.com.amazonia.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.amazonia.model.Cupom;
import br.com.amazonia.model.InfoProduto;

public class CupomDAO {
	
	InfoProduto produto1 = new InfoProduto("Alice no País das Maravilhas", "Fantasia", "Livro", 60, "Ambos", "0.50");
	InfoProduto produto2 = new InfoProduto("O Rei do Inverno", "Ficção Histórica", "e-Reader", 40, "Digital", "0");

	Cupom cupom1 = new Cupom("10conto", produto1, 10, "10/05/2020");
	Cupom cupom2 = new Cupom("10conto", produto2, 5, "01/05/2020");

	List<Cupom> cupons = Arrays.asList(cupom1, cupom2);

	public List<Cupom> buscaDesconto(String c) {
		// Aqui retornaria informações do banco
		List<Cupom> produtoCupom = new ArrayList<Cupom>();
		for (Cupom cupom : cupons) {
			if (cupom.getNomeCupom().equalsIgnoreCase(c)) {
				produtoCupom.add(cupom);
			}
		}
		return produtoCupom;
	}
}