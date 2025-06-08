package objetos;

/**
 * Classe para o controle de filtros para pesquisa
 */
public class Filtros {
	private float precoProcurado;
	private String formatoProcurado;
	private int paginaProcurada;
	
	public float getPrecoProcurado() {
		return precoProcurado;
	}
	public void setPrecoProcurado(float precoProcurado) {
		this.precoProcurado = precoProcurado;
	}
	public String getFormatoProcurado() {
		return formatoProcurado;
	}
	public void setFormatoProcurado(String formatoProcurado) {
		this.formatoProcurado = formatoProcurado;
	}
	public int getPaginaProcurada() {
		return paginaProcurada;
	}
	public void setPaginaProcurada(int paginaProcurada) {
		this.paginaProcurada = paginaProcurada;
	}
}
