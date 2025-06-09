package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import banco_de_dados.*;
import objetos.*;

public class TelaPrincipal extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private CarrinhoDAO carrinhoDAO;
    private LivroDAO livroDAO;
    private int codCliente;
    private PainelAdministrativo painelAdministrativo;

    public TelaPrincipal(int codCliente) {
        this.codCliente = codCliente;
        this.carrinhoDAO = new CarrinhoDAO();
        this.livroDAO = new LivroDAO();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Livraria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create header panel with navigation buttons
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton catalogoButton = new JButton("Catálogo");
        catalogoButton.addActionListener(e -> cardLayout.show(mainPanel, "CATALOGO"));
        
        JButton carrinhoButton = new JButton("Carrinho");
        carrinhoButton.addActionListener(e -> cardLayout.show(mainPanel, "CARRINHO"));
        
        JButton perfilButton = new JButton("Perfil");
        perfilButton.addActionListener(e -> cardLayout.show(mainPanel, "PERFIL"));

        // Add admin panel button
        JButton adminButton = new JButton("Painel Administrativo");
        adminButton.addActionListener(e -> {
            if (painelAdministrativo == null) {
                painelAdministrativo = new PainelAdministrativo(this);
            }
            painelAdministrativo.setVisible(true);
            setVisible(false);
        });

        headerPanel.add(catalogoButton);
        headerPanel.add(carrinhoButton);
        headerPanel.add(perfilButton);
        headerPanel.add(adminButton);

        // Create content panels
        JPanel catalogoPanel = createCatalogoPanel();
        JPanel carrinhoPanel = createCarrinhoPanel();
        JPanel perfilPanel = createPerfilPanel();

        // Add panels to card layout
        mainPanel.add(catalogoPanel, "CATALOGO");
        mainPanel.add(carrinhoPanel, "CARRINHO");
        mainPanel.add(perfilPanel, "PERFIL");

        // Add panels to frame
        setLayout(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        // Show catalog by default
        cardLayout.show(mainPanel, "CATALOGO");
    }

    // ... rest of the code remains the same ...
} 