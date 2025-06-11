package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que modela a tela de login do sistema.
 * Permite que usuários façam autenticação no sistema.
 */
public class TelaLogin extends JPanel {
    /** Referência para a janela principal do sistema */
    private final MainFrame mainFrame;

    /**
     * Construtor da tela de login.
     * @param mainFrame referência para a janela principal do sistema
     */
    public TelaLogin(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
    }

    /**
     * Inicializa a interface gráfica da tela de login.
     * Cria e configura os componentes visuais necessários.
     */
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
