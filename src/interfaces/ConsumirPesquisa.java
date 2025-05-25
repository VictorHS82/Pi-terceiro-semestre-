package interfaces;

import java.util.List;
import banco_de_dados.PesquisaDAO;
import objetos.Livros;

public class ConsumirPesquisa {

	public static void main(String[] args) {
		PesquisaDAO dao = new PesquisaDAO();
		
		String termoBusca = "Java";
		Integer maxPaginas = 500;
		Float precoMaximo = 80.0f;
		String formato = "Brochura";
		
		List<Livros> resultado = dao.pesquisarLivro(termoBusca, maxPaginas, precoMaximo, formato);
		
		if (resultado.isEmpty()) {
			System.out.println("Nenhum livro encontrado");
		} else {
			for (Livros livro : resultado) {
				System.out.println("Codigo: " + livro.getCod_livro());
				System.out.println("Título: " + livro.getTitulo());
				System.out.println("Autor: " + livro.getAutor());
				System.out.println("Pagínas: " + livro.getPaginas());
				System.out.println("Preço: R$ " + livro.getPrecoUnid());
				System.out.println("formato: " + livro.getFormato());
				System.out.println("---------------------------");
			}
		}

	}

}
