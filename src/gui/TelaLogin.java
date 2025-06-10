package gui;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JPanel {
    private final MainFrame mainFrame;

    public TelaLogin(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        JTextField txtUsuario = new JTextField();
        JPasswordField txtSenha = new JPasswordField();

        formPanel.add(new JLabel("Usuário:"));
        formPanel.add(txtUsuario);
        formPanel.add(new JLabel("Senha:"));
        formPanel.add(txtSenha);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> mainFrame.mostrarTelaCatalogo(1)); // Login fake com ID 1

        formPanel.add(new JLabel());
        formPanel.add(btnLogin);

        add(new JLabel("Login", SwingConstants.CENTER), BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }
}
