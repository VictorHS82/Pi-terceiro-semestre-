package gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Sistema Livraria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mostrarTelaLogin();
    }

    public void mostrarTelaLogin() {
        setContentPane(new TelaLogin(this));
        revalidate();
        repaint();
    }

    public void mostrarTelaCatalogo(int codCliente) {
        setContentPane(new CatalogoLivros(this, codCliente));
        revalidate();
        repaint();
    }

    public void mostrarTelaPerfil(int codCliente) {
        setContentPane(new TelaPerfil(codCliente));
        revalidate();
        repaint();
    }

    public void mostrarPainelAdmin(int codClienteAtual) {
        setContentPane(new PainelAdmin(this, codClienteAtual));
        revalidate();
        repaint();
    }
}
