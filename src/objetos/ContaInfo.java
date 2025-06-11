package objetos;

/**
 * Classe que modela a busca de informações das contas
 */
public class ContaInfo {
    /** Tipo da conta (Usuário ou Administrador) */
    private String tipoConta;
    /** ID único da conta */
    private int id;
    /** Nome do titular da conta */
    private String nome;
    /** Email do titular da conta */
    private String email;
    /** Telefone do titular da conta */
    private String telefone;
    /** Endereço do titular da conta */
    private String endereco;
    /** Nome do administrador que criou a conta (apenas para contas de administrador) */
    private String criadoPor;

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

    /**
     * Retorna o tipo da conta.
     * @return String contendo o tipo da conta (Usuário ou Administrador)
     */
    public String getTipoConta() {
        return tipoConta;
    }

    /**
     * Retorna o id da conta.
     * @return int contendo o id da conta
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome da conta.
     * @return String contendo o nome da conta
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o email da conta.
     * @return String contendo o email da conta
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retorna o telefone da conta.
     * @return String contendo o telefone da conta
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Retorna o endereço da conta.
     * @return String contendo o endereço da conta
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Retorna quem criou a conta (caso seja administrador).
     * @return String contendo o nome de quem criou a conta
     */
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
