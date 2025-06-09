package gui;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema da Livraria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba de Catálogo de Livros
        CatalogoLivros catalogoPanel = new CatalogoLivros();
        tabbedPane.addTab("Catálogo", catalogoPanel.getContentPane());

        // Aba Painel Administrativo
        PainelAdmin painelAdmin = new PainelAdmin();
        tabbedPane.addTab("Administração", painelAdmin);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
