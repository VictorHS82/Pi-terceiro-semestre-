package gui;

import javax.swing.*;

/**
 * Mainframe para controle de telas 
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Sistema Livraria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mostrarTelaLogin();
    }

    /**
     * Método para a tela login
     */
    public void mostrarTelaLogin() {
        setContentPane(new TelaLogin(this));
        revalidate();
        repaint();
    }

    /**
     * Método para mostrar tela de catalogo
     * @param codCliente
     */
    public void mostrarTelaCatalogo(int codCliente) {
        setContentPane(new CatalogoLivros(this, codCliente));
        revalidate();
        repaint();
    }

    /**
     * Método para mostrar a tela de perfil
     * @param codCliente
     */
    public void mostrarTelaPerfil(int codCliente) {
        setContentPane(new TelaPerfil(codCliente));
        revalidate();
        repaint();
    }

    /**
     * Tela que leva ao Painel administrador
     * @param codClienteAtual
     */
    public void mostrarPainelAdmin(int codClienteAtual) {
        setContentPane(new PainelAdmin(this, codClienteAtual));
        revalidate();
        repaint();
    }
}
