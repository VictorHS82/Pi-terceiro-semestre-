package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Classe para o controle das telas relacionadas ao Painel Administrativo
 */
public class PainelAdmin extends JPanel {
    public PainelAdmin(MainFrame mainFrame, int codClienteAtual) {
        setLayout(new BorderLayout());

        JTabbedPane abasAdmin = new JTabbedPane();
        abasAdmin.addTab("Livros", new AdminLivrosPanel());
        abasAdmin.addTab("Contas", new PainelContas());
        abasAdmin.addTab("Pedidos", new PainelPedidos());
        abasAdmin.addTab("Pagamentos", new PainelPagamentos());

        add(abasAdmin, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Catálogo");
        btnVoltar.addActionListener(e -> mainFrame.mostrarTelaCatalogo(codClienteAtual));
        add(btnVoltar, BorderLayout.SOUTH);
    }
}