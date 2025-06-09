package gui;

import javax.swing.*;
import java.awt.*;

public class PainelAdmin extends JPanel {

    public PainelAdmin() {
        setLayout(new BorderLayout());

        JTabbedPane abasAdmin = new JTabbedPane();

        // Painéis para cada tipo de dado
        abasAdmin.addTab("Livros", new AdminLivrosPanel());
        abasAdmin.addTab("Usuários", new AdminUsuariosPanel());
        abasAdmin.addTab("Pedidos", new AdminPedidosPanel());
        abasAdmin.addTab("Pagamentos", new AdminPagamentosPanel());

        add(abasAdmin, BorderLayout.CENTER);
    }
}
