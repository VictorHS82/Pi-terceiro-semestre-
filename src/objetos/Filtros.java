package objetos;

/**
 * Classe para o controle de filtros para pesquisa
 */
public class Filtros {
	private float precoProcurado;
	private String formatoProcurado;
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
