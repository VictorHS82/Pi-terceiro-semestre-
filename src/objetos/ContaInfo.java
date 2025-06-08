package objetos;

/**
 * Classe que modela a busca de informações das contas
 */
public class ContaInfo {
    private String tipoConta; // "Usuário" ou "Administrador"
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String criadoPor; // apenas se for administrador

    /**
     * Constructor de ContaInfo
     * @param tipoConta
     * @param id
     * @param nome
     * @param email
     * @param telefone
     * @param endereco
     * @param criadoPor
     */
    public ContaInfo(String tipoConta, int id, String nome, String email, String telefone, String endereco, String criadoPor) {
        this.tipoConta = tipoConta;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.criadoPor = criadoPor;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %d, Nome: %s, Email: %s, Telefone: %s, Endereço: %s%s",
                tipoConta, id, nome, email, telefone, endereco,
                (criadoPor != null ? ", Criado por: " + criadoPor : ""));
    }
}
