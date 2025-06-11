package interfacesDAO;

import java.util.List;

import objetos.Livros;

/**
 * Interface de Pesdquisa
 */
public interface BasePesquisa {

	/**
	 * Classe para criar uma query de busca
	 * @param termoBusca titulo ou autor de um livro
	 * @param maxPaginas maximo de paginas de um livro
	 * @param precoMaximo maximo de preco de um livro
	 * @param formato formato desejado da midia
	 * @return lista com os itens correspondentes
	 */
	List<Livros> pesquisarLivro(String termoBusca, Integer maxPaginas, Float precoMaximo, String formato);

}