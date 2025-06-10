package objetos;

/**
 * Representa um livro com informações detalhadas como título, autor,
 * ISBN, descrição, entre outras características.
 */
public class Livros {
	private String titulo, autor, descricao, anopublicacao, isbn, genero, idioma, formato, imagem;
	private int cod_livro, paginas, quantidade;
	private float peso, preco_unitario;
	
	/**
	 * Constructor da classe livro
	 * @param cod_livro
	 * @param titulo
	 * @param autor
	 * @param descricao
	 * @param anopublicacao
	 * @param isbn
	 * @param genero
	 * @param idioma
	 * @param formato
	 * @param paginas
	 * @param quantidade
	 * @param peso
	 * @param preco_unitario
	 */
	public Livros(int cod_livro, String titulo, String autor, String descricao, String anopublicacao, String isbn,
			String genero, String idioma, String formato, int paginas, int quantidade, float peso, float preco_unitario, String imagem) {
		super();
		this.cod_livro = cod_livro;
		this.titulo = titulo;
		this.autor = autor;
		this.descricao = descricao;
		this.anopublicacao = anopublicacao;
		this.isbn = isbn;
		this.genero = genero;
		this.idioma = idioma;
		this.formato = formato;
		this.paginas = paginas;
		this.quantidade = quantidade;
		this.peso = peso;
		this.preco_unitario = preco_unitario;
		this.imagem = imagem;
	}

	/**
	 * Retorna o título do livro.
	 * @return String contendo o título do livro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Define o título do livro.
	 * @param titulo título do livro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Retorna o autor do livro.
	 * @return String contendo o autor do livro
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Define o autor do livro.
	 * @param autor autor do livro
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Retorna a descrição do livro.
	 * @return String contendo a descrição do livro
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Define a descrição do livro.
	 * @param descricao descrição do livro
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Retorna o ano de publicação do livro.
	 * @return String contendo o ano de publicação
	 */
	public String getAnopublicacao() {
		return anopublicacao;
	}

	/**
	 * Define o ano de publicação do livro.
	 * @param anopublicacao ano de publicação
	 */
	public void setAnopublicacao(String anopublicacao) {
		this.anopublicacao = anopublicacao;
	}

	/**
	 * Retorna o ISBN do livro.
	 * @return String contendo o ISBN do livro
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Define o ISBN do livro.
	 * @param isbn ISBN do livro
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Retorna o gênero do livro.
	 * @return String contendo o gênero do livro
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Define o gênero do livro.
	 * @param genero gênero do livro
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Retorna o idioma do livro.
	 * @return String contendo o idioma do livro
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Define o idioma do livro.
	 * @param idioma idioma do livro
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * Retorna o formato do livro.
	 * @return String contendo o formato do livro
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * Define o formato do livro.
	 * @param formato formato do livro
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * Retorna a imagem do livro.
	 * @return String contendo o caminho da imagem do livro
	 */
	public String getImagem() {
		return imagem;
	}

	/**
	 * Define a imagem do livro.
	 * @param imagem caminho da imagem do livro
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	/**
	 * Retorna o código do livro.
	 * @return int contendo o código do livro
	 */
	public int getCod_livro() {
		return cod_livro;
	}

	/**
	 * Define o código do livro.
	 * @param cod_livro código do livro
	 */
	public void setCod_livro(int cod_livro) {
		this.cod_livro = cod_livro;
	}

	/**
	 * Retorna o número de páginas do livro.
	 * @return int contendo o número de páginas
	 */
	public int getPaginas() {
		return paginas;
	}

	/**
	 * Define o número de páginas do livro.
	 * @param paginas número de páginas
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	/**
	 * Retorna a quantidade disponível do livro.
	 * @return int contendo a quantidade disponível
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Define a quantidade disponível do livro.
	 * @param quantidade quantidade disponível
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o peso do livro.
	 * @return float contendo o peso do livro
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * Define o peso do livro.
	 * @param peso peso do livro
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * Retorna o preço unitário do livro.
	 * @return float contendo o preço unitário
	 */
	public float getPreco_unitario() {
		return preco_unitario;
	}

	/**
	 * Define o preço unitário do livro.
	 * @param preco_unitario preço unitário
	 */
	public void setPreco_unitario(float preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
}
