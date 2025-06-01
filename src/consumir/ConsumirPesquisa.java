package consumir;

import java.util.List;
import banco_de_dados.Pesquisa;
import objetos.Livros;

public class ConsumirPesquisa {

	public static void main(String[] args) {
		Pesquisa dao = new Pesquisa();
		
		String termoBusca = "Carlos Souza";
		Integer maxPaginas = 600;
		Float precoMaximo = 90.00f;
		String formato = "Digital";
		
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
