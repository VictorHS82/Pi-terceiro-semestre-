package objetos;

/**
 * Classe para filtros
 */
public class Filtros {
	/** Preço máximo para filtrar livros */
	private float precoProcurado;
	/** Formato desejado para filtrar livros */
	private String formatoProcurado;
	/** Número mínimo de páginas para filtrar livros */
	private int paginaProcurada;
	
	/**
	 * Retorna o preço procurado.
	 * @return float contendo o preço procurado
	 */
	public float getPrecoProcurado() {
		return precoProcurado;
	}
	/**
	 * Define o preço procurado.
	 * @param precoProcurado preço procurado
	 */
	public void setPrecoProcurado(float precoProcurado) {
		this.precoProcurado = precoProcurado;
	}
	/**
	 * Retorna o formato procurado.
	 * @return String contendo o formato procurado
	 */
	public String getFormatoProcurado() {
		return formatoProcurado;
	}
	/**
	 * Define o formato procurado.
	 * @param formatoProcurado formato procurado
	 */
	public void setFormatoProcurado(String formatoProcurado) {
		this.formatoProcurado = formatoProcurado;
	}
	/**
	 * Retorna a página procurada.
	 * @return int contendo a página procurada
	 */
	public int getPaginaProcurada() {
		return paginaProcurada;
	}
	/**
	 * Define a página procurada.
	 * @param paginaProcurada página procurada
	 */
	public void setPaginaProcurada(int paginaProcurada) {
		this.paginaProcurada = paginaProcurada;
	}
}
