package interfacesDAO;

import java.util.List;

import objetos.Livros;

public interface testedao extends BaseDAO {

	/**
	 * Cadastra um livro no banco de dados
	 * @param livros recebe um novo objeto livro
	 * @return true or false
	 */
	boolean cadastrarLivro(Livros livros);

	/**
	 * Lista todos as tuplas/linhas da entidade livro do banco de dados
	 * @return lista lista com todos os itens cadastrados no banco
	 */
	List<Livros> listarTodos();

	/**
	 * Busca as informações de um livro com base no código fornecido
	 * @param cod cod do livro a ser procurado
	 * @return livro livro quê foi encontrado pela consulta
	 */
	Livros buscarPorCodigo(String cod);

	/**
	 * Busca todas as tuplas/linhas do banco, mas retorna apenas os atributos cod_livro, titulo e quantidade
	 * @return estoque lista com o cod_livro, titulo e quantidade de todas as linhas/tuplas do banco da entidade livro
	 */
	List<Livros> consultarEstoque();

	/**
	 * Atualiza os atributos de um livro
	 * @param livro recebe objeto com os todos os parametros, e verifica quais colunas devem ser alteradas
	 * @return linhasAfetadas mostra quantas infromações foram modificadas
	 * @return false caso a operação falhe
	 */
	boolean atualizarLivro(Livros livro);

	/**
	 * Deleta um livro do banco de dados
	 * @param cod_livro código do livro a ser deletado
	 * @return linhasAfetadas quantida de linhas deletadas
	 */
	boolean deletarLivro(String cod_livro);

}