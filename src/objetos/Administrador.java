package objetos;

public class Administrador extends Usuario {

	private String criado_por;

	public Administrador(int cod_usuario, String nome, String senha, String email, String criado_por) {
		super(cod_usuario, nome, senha, email);
		this.criado_por = criado_por;
	}

	public String getCriado_por() {
		return criado_por;
	}

	public void setCriado_por(String criado_por) {
		this.criado_por = criado_por;
	}


}
