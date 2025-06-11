package consumir;

import java.util.List;

import banco_de_dados.LivroDAO;
import objetos.Livros;

/**
 * Classe de teste para LivroDAO
 */
public class ConsumirLivros {

	public static void main(String[] args) {
		cadastrar();
		//alterar();
		//listar();
		//buscarid();
		//excluir();
	}
	
	/**
	 * Método para cadastrar livro
	 */
	public static void cadastrar() {	
		LivroDAO dao = new LivroDAO();
		
		Livros livro = new Livros(
		 0, "Python", "Carlos Souza", "Livro Avançado de Java",
		"2024", "43554545", "Programação", "Português", "Digital", 550, 7, 0.85f, 89.90f, "link"
		);
		dao.cadastrarLivro(livro);		
	}
	
	/**
	 * Classe para alterar livro
	 */
	public static void alterar() {
		LivroDAO dao = new LivroDAO();
		
		Livros livro = new Livros(
		0, "Python", "Marco Geraldo", "Livro Avançado de Java",
		"2024", "43554545", "Programação", "Português", "Digital", 550, 7, 0.85f, 89.90f, "link"
		);
		dao.atualizarLivro(livro);	
	}

	/**
	 * Classe para listar livros
	 */
	public static void listar() {
		LivroDAO dao = new LivroDAO();
			
		List<Livros> lista = dao.listarTodos();
		for (Livros livro : lista) {
			System.out.println("Código: " + livro.getCod_livro());
			System.out.println("Código: " + livro.getTitulo());
			System.out.println("Código: " + livro.getAutor());
			System.out.println("Quantidade: " + livro.getQuantidade());
			System.out.println("------");
			//Se necessário, adicionar os prints das outras informações
		}
	}
	
	/**
	 * Classe para buscar livro por ID
	 */
	public static void buscarid() {
		LivroDAO dao = new LivroDAO();
		
		Livros livro = dao.buscarPorCodigo(2);
		
		if(livro != null) {
		System.out.println("Código: " + livro.getCod_livro());
		System.out.println("Código: " + livro.getTitulo());
		System.out.println("Código: " + livro.getAutor());
		System.out.println("Quantidade: " + livro.getQuantidade());
	} else {
		System.out.println("Id não econtrado");
	}
}
	/**
	 * Método para excluir livro
	 */
	public static void excluir() {
		LivroDAO dao = new LivroDAO();
		
		boolean removido = dao.deletarLivro(2);
		
		if (removido) {
			System.out.println("Livro excluído");
		} else {
			System.out.println("Falha ao excluir");
		}
	}
}