package objetos;

public class Item_carrinho{
	private int cod_item_carrinho;
	private int cod_carrinho;
	private int cod_livro;
	private String nome_livro;
	private int quantidade;
	private float preco;

	public Item_carrinho(int cod_item_carrinho, int cod_carrinho, int cod_livro, String nome_livro, int quantidade,
			float preco) {
		super();
		this.cod_item_carrinho = cod_item_carrinho;
		this.cod_carrinho = cod_carrinho;
		this.cod_livro = cod_livro;
		this.nome_livro = nome_livro;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	public int getCod_item_carrinho() {
		return cod_item_carrinho;
	}
	public void setCod_item_carrinho(int cod_item_carrinho) {
		this.cod_item_carrinho = cod_item_carrinho;
	}
	public int getCod_carrinho() {
		return cod_carrinho;
	}
	public void setCod_carrinho(int cod_carrinho) {
		this.cod_carrinho = cod_carrinho;
	}
	public int getCod_livro() {
		return cod_livro;
	}
	public void setCod_livro(int cod_livro) {
		this.cod_livro = cod_livro;
	}
	public String getNome_livro() {
		return nome_livro;
	}
	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	
}
