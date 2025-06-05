package consumir;

import java.util.List;

import banco_de_dados.LivroDAO;
import interfacesDAO.testedao;
import objetos.Livros;

// Classe para testar os métodos de LivroDAO, não mexer
public class ConsumirLivros {

	public static void main(String[] args) {
		cadastrar();
		//alterar();
		//listar();
		//buscarid();
		//excluir();
	}
	
	public static void cadastrar() {	
		testedao dao = new LivroDAO();
		
		Livros livro = new Livros(
		"002", "Python", "Carlos Souza", "Livro Avançado de Java",
		"2024", "43554545", "Programação", "Português", "Digital", 550, 7, 0.85f, 89.90f
		);
		dao.cadastrarLivro(livro);		
	}
	
	public static void alterar() {
		testedao dao = new LivroDAO();
		
		Livros livro = new Livros(
		"002", "Python", "Marco Geraldo", "Livro Avançado de Java",
		"2024", "43554545", "Programação", "Português", "Digital", 550, 7, 0.85f, 89.90f
		);
		dao.atualizarLivro(livro);	
	}

	public static void listar() {
		testedao dao = new LivroDAO();
			
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
	
	public static void buscarid() {
		testedao dao = new LivroDAO();
		
		Livros livro = dao.buscarPorCodigo("002");
		
		if(livro != null) {
		System.out.println("Código: " + livro.getCod_livro());
		System.out.println("Código: " + livro.getTitulo());
		System.out.println("Código: " + livro.getAutor());
		System.out.println("Quantidade: " + livro.getQuantidade());
	} else {
		System.out.println("Id não econtrado");
	}
}
	public static void excluir() {
		testedao dao = new LivroDAO();
		
		boolean removido = dao.deletarLivro("002");
		
		if (removido) {
			System.out.println("Livro excluído");
		} else {
			System.out.println("Falha ao excluir");
		}
	}
}