package interfaces;

import banco_de_dados.LivroDAO;
import objetos.Livros;

public class ConsumirLivros {

	public static void main(String[] args) {
		LivroDAO dao = new LivroDAO();
		
		Livros livro = new Livros(
		"001", "Java Profissional", "Carlos Souza", "Livro Avançado de Java",
		"2024", "43554545", "Programação", "Português", "Capa dura", "Brilhante",
		"Colorido", 550, 7, 0.85f, 89.90f
		);
		dao.cadastrarLivro(livro);		
	}
}
