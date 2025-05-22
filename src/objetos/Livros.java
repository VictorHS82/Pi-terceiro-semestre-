package objetos;

/**
 * Representa um livro com informações detalhadas como título, autor,
 * ISBN, descrição, entre outras características.
 */
public class Livros {
	private String cod_livro, titulo, autor, descricao, anopublicacao, isbn, genero, idioma, formato;
	private int paginas, quantidade;
	private float peso, preco_unitario;

	
    
	
	public Livros(String cod_livro, String titulo, String autor, String descricao, String anopublicacao, String isbn,
			String genero, String idioma, String formato, int paginas, int quantidade,
			float peso, float preco_unitario) {
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
		this.preco_unitario = preco_unitario;
	}

	/**
	 * Cadastra um novo livro no sistema.
	 */
	private static void cadastrar() {
		
	}

	/**
	 * Modifica os dados de um livro existente.
	 * (Método ainda não implementado)
	 */
	private static void modificarLivro() {
		
	}

	/**
	 * Verifica a quantidade de livros disponíveis em estoque.
	 * (Método ainda não implementado)
	 */
	private static void verificarestoque() {
		
	}

	/**
	 * @return o código do livro
	 */
	public String getCod_livro() {
		return cod_livro;
	}

	/**
	 * @param cod_livro define o código do livro
	 */
	public void setCod_livro(String cod_livro) {
		this.cod_livro = cod_livro;
	}

	/**
	 * @return o título do livro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo define o título do livro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return o autor do livro
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor define o autor do livro
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return a descrição do livro
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao define a descrição do livro
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return o preço unitário do livro
	 */
	public float getPrecoUnid() {
		return preco_unitario;
	}

	/**
	 * @param precoUnid define o preço unitário do livro
	 */
	public void setPrecoUnid(float preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	/**
	 * @return o ano de publicação do livro
	 */
	public String getAnoPublicacao() {
		return anopublicacao;
	}

	/**
	 * @param publicacao define o ano de publicação do livro
	 */
	public void setPublicacao(String anopublicacao) {
		this.anopublicacao = anopublicacao;
	}

	/**
	 * @return o número ISBN do livro
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn define o número ISBN do livro
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return o gênero do livro
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero define o gênero do livro
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return o idioma do livro
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * @param idioma define o idioma do livro
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * @return o formato do livro (ex: brochura, capa dura)
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * @param formato define o formato do livro
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * @return o número de páginas do livro
	 */
	public int getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas define o número de páginas do livro
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	/**
	 * @return o peso do livro em gramas
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * @param peso define o peso do livro em gramas
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * @return a quantidade disponível em estoque
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade define a quantidade disponível em estoque
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
