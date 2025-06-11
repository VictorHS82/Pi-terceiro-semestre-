package gui;

import javax.swing.*;

/**
 * Mainframe para controle de telas do sistema de livraria.
 * Esta classe gerencia a navegação entre as diferentes telas do sistema.
 */
public class MainFrame extends JFrame {
    /**
     * Construtor da classe MainFrame.
     * Inicializa a janela principal e configura suas propriedades básicas.
     */
    public MainFrame() {
        setTitle("Sistema Livraria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mostrarTelaLogin();
    }

    /**
     * Método para exibir a tela de login.
     * Substitui o conteúdo atual pelo painel de login.
     */
    public void mostrarTelaLogin() {
        setContentPane(new TelaLogin(this));
        revalidate();
        repaint();
    }

    /**
     * Método para mostrar tela de catálogo de livros.
     * @param codCliente código do cliente que está acessando o catálogo
     */
    public void mostrarTelaCatalogo(int codCliente) {
        setContentPane(new CatalogoLivros(this, codCliente));
        revalidate();
        repaint();
    }

    /**
     * Método para mostrar a tela de perfil do usuário.
     * @param codCliente código do cliente cujo perfil será exibido
     */
    public void mostrarTelaPerfil(int codCliente) {
        setContentPane(new TelaPerfil(codCliente));
        revalidate();
        repaint();
    }

    /**
     * Método para exibir o painel do administrador.
     * @param codClienteAtual código do administrador que está acessando o painel
     */
    public void mostrarPainelAdmin(int codClienteAtual) {
        setContentPane(new PainelAdmin(this, codClienteAtual));
        revalidate();
        repaint();
    }
}
