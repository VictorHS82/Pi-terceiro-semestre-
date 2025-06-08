package objetos;

public abstract class Usuario {
    private int cod_usuario;
	private String nome;
	private String senha;
	private String email;
	
	public Usuario(int cod_usuario, String nome, String senha, String email) {
		super();
		this.cod_usuario = cod_usuario;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public int getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
