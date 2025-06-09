package gui;

import javax.swing.*;
import java.awt.*;

public class PainelAdmin extends JPanel {

    public PainelAdmin() {
        setLayout(new BorderLayout());

        JTabbedPane abasAdmin = new JTabbedPane();

        // Painéis para cada tipo de dado
        abasAdmin.addTab("Livros", new AdminLivrosPanel());
        abasAdmin.addTab("Contas", new PainelContas());
        abasAdmin.addTab("Pedidos", new PainelPedidos());
        abasAdmin.addTab("Pagamentos", new PainelPagamentos());

        add(abasAdmin, BorderLayout.CENTER);
    }
}
