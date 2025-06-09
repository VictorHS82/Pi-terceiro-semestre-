package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import banco_de_dados.LivroDAO;
import banco_de_dados.CarrinhoDAO;
import banco_de_dados.PedidoDAO;
import banco_de_dados.PagamentoDAO;
import objetos.Livros;
import objetos.Item_carrinho;
import objetos.Pedido;
import objetos.Pagamento;

public class CatalogoLivros extends JFrame {
    private LivroDAO livroDAO;
    private CarrinhoDAO carrinhoDAO;
    private PedidoDAO pedidoDAO;
    private PagamentoDAO pagamentoDAO;
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private int codClienteAtual = 1; // Temporário - deve vir do login
    private JButton cartButton;

    public CatalogoLivros() {
        livroDAO = new LivroDAO();
        carrinhoDAO = new CarrinhoDAO();
        pedidoDAO = new PedidoDAO();
        pagamentoDAO = new PagamentoDAO();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Catálogo de Livros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Adiciona botão do carrinho no topo
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        cartButton = new JButton("Ver Carrinho");
        cartButton.addActionListener(e -> showCart());
        topPanel.add(cartButton);
        add(topPanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);

        loadBooks();
    }

    private void loadBooks() {
        List<Livros> livros = livroDAO.listarTodos();
        mainPanel.removeAll();

        for (Livros livro : livros) {
            JPanel bookPanel = createBookPanel(livro);
            mainPanel.add(bookPanel);
            mainPanel.add(Box.createVerticalStrut(10)); // Espaço entre os livros
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private JPanel createBookPanel(Livros livro) {
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);

        // Painel para a imagem
        JLabel imageLabel = new JLabel();
        if (livro.getImagem() != null && !livro.getImagem().isEmpty()) {
            ImageIcon icon = new ImageIcon(livro.getImagem());
            Image image = icon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
        } else {
            imageLabel.setIcon(new ImageIcon("src/resources/no-image.png")); // Imagem padrão
        }
        imageLabel.setPreferredSize(new Dimension(100, 150));
        panel.add(imageLabel, BorderLayout.WEST);

        // Painel para as informações do livro
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);

        JLabel tituloLabel = new JLabel(livro.getTitulo());
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel autorLabel = new JLabel("Autor: " + livro.getAutor());
        JLabel precoLabel = new JLabel(String.format("Preço: R$ %.2f", livro.getPrecoUnid()));

        infoPanel.add(tituloLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(autorLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(precoLabel);

        panel.add(infoPanel, BorderLayout.CENTER);

        // Botão Comprar
        JButton comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(e -> showDetalhesLivro(livro));
        panel.add(comprarButton, BorderLayout.EAST);

        return panel;
    }

    private void showDetalhesLivro(Livros livro) {
        JDialog dialog = new JDialog(this, "Detalhes do Livro", true);
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Imagem do livro
        JLabel imageLabel = new JLabel();
        if (livro.getImagem() != null && !livro.getImagem().isEmpty()) {
            ImageIcon icon = new ImageIcon(livro.getImagem());
            Image image = icon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));
        } else {
            imageLabel.setIcon(new ImageIcon("src/resources/no-image.png"));
        }
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.NORTH);

        // Informações detalhadas
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        infoPanel.add(new JLabel("Título: " + livro.getTitulo()));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("Autor: " + livro.getAutor()));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("ISBN: " + livro.getIsbn()));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("Gênero: " + livro.getGenero()));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("Idioma: " + livro.getIdioma()));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("Formato: " + livro.getFormato()));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("Páginas: " + livro.getPaginas()));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("Preço: R$ " + String.format("%.2f", livro.getPrecoUnid())));
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(new JLabel("Quantidade em estoque: " + livro.getQuantidade()));

        JTextArea descricaoArea = new JTextArea(livro.getDescricao());
        descricaoArea.setLineWrap(true);
        descricaoArea.setWrapStyleWord(true);
        descricaoArea.setEditable(false);
        JScrollPane descricaoScroll = new JScrollPane(descricaoArea);
        descricaoScroll.setPreferredSize(new Dimension(300, 100));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(new JLabel("Descrição:"));
        infoPanel.add(descricaoScroll);

        panel.add(infoPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        // Campo de quantidade
        JSpinner quantidadeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, livro.getQuantidade(), 1));
        buttonPanel.add(new JLabel("Quantidade:"));
        buttonPanel.add(quantidadeSpinner);

        // Botão Adicionar ao Carrinho
        JButton adicionarButton = new JButton("Adicionar ao Carrinho");
        adicionarButton.addActionListener(e -> {
            int quantidade = (Integer) quantidadeSpinner.getValue();
            adicionarAoCarrinho(livro, quantidade);
            dialog.dispose();
        });
        buttonPanel.add(adicionarButton);

        // Botão Fechar
        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(e -> dialog.dispose());
        buttonPanel.add(fecharButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void adicionarAoCarrinho(Livros livro, int quantidade) {
        try {
            // Validar quantidade
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this,
                    "A quantidade deve ser maior que zero.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (quantidade > livro.getQuantidade()) {
                JOptionPane.showMessageDialog(this,
                    "Quantidade indisponível em estoque. Máximo disponível: " + livro.getQuantidade(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verificar se já existe no carrinho
            List<Item_carrinho> itensCarrinho = carrinhoDAO.get(codClienteAtual);
            for (Item_carrinho item : itensCarrinho) {
                if (item.getCod_livro() == livro.getCod_livro()) {
                    int novaQuantidade = item.getQuantidade() + quantidade;
                    if (novaQuantidade > livro.getQuantidade()) {
                        JOptionPane.showMessageDialog(this,
                            "Quantidade total excede o estoque disponível.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // Criar carrinho se não existir
            carrinhoDAO.criarCarrinho(codClienteAtual);

            // Criar item do carrinho
            Item_carrinho item = new Item_carrinho(
                0, // cod_item_carrinho será gerado pelo banco
                codClienteAtual, // cod_carrinho
                livro.getCod_livro(),
                livro.getTitulo(),
                quantidade,
                livro.getPrecoUnid()
            );

            // Adicionar ao carrinho
            if (carrinhoDAO.post(item)) {
                JOptionPane.showMessageDialog(this,
                    "Livro adicionado ao carrinho com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Erro ao adicionar livro ao carrinho.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao processar operação: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showCart() {
        JDialog cartDialog = new JDialog(this, "Carrinho de Compras", true);
        cartDialog.setSize(600, 400);
        cartDialog.setLocationRelativeTo(this);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tabela do carrinho
        String[] columnNames = {"Item", "Quantidade", "Preço Unitário", "Subtotal"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable cartTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(cartTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Carregar itens do carrinho
        List<Item_carrinho> itens = carrinhoDAO.get(codClienteAtual);
        float totalTemp = 0;
        for (Item_carrinho item : itens) {
            float subtotal = item.getQuantidade() * item.getPreco();
            totalTemp += subtotal;
            model.addRow(new Object[]{
                item.getNome_livro(),
                item.getQuantidade(),
                String.format("R$ %.2f", item.getPreco()),
                String.format("R$ %.2f", subtotal)
            });
        }
        final float total = totalTemp;

        // Painel de total e botões
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        
        // Painel de total
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.add(new JLabel(String.format("Total: R$ %.2f", total)));
        bottomPanel.add(totalPanel, BorderLayout.NORTH);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        // Botão Finalizar Compra
        JButton finalizarButton = new JButton("Finalizar Compra");
        finalizarButton.addActionListener(e -> {
            if (itens.isEmpty()) {
                JOptionPane.showMessageDialog(cartDialog,
                    "O carrinho está vazio!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(
                cartDialog,
                "Deseja finalizar a compra?\nTotal: R$ " + String.format("%.2f", total),
                "Confirmar Compra",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (confirmacao == JOptionPane.YES_OPTION) {
                cartDialog.dispose();
                showPaymentMethodSelection(total, itens);
            }
        });
        buttonPanel.add(finalizarButton);

        // Botão Fechar
        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(e -> cartDialog.dispose());
        buttonPanel.add(fecharButton);

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        cartDialog.add(mainPanel);
        cartDialog.setVisible(true);
    }

    private void showPaymentMethodSelection(float total, List<Item_carrinho> itens) {
        JDialog paymentDialog = new JDialog(this, "Forma de Pagamento", true);
        paymentDialog.setSize(400, 300);
        paymentDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Escolha a forma de pagamento", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Opções de pagamento
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        String[] paymentMethods = {"PIX", "Crédito", "Débito", "Boleto Bancário"};
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] buttons = new JRadioButton[4];

        for (int i = 0; i < paymentMethods.length; i++) {
            buttons[i] = new JRadioButton(paymentMethods[i]);
            group.add(buttons[i]);
            optionsPanel.add(buttons[i]);
        }
        buttons[0].setSelected(true); // PIX como padrão

        panel.add(optionsPanel, BorderLayout.CENTER);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(e -> {
            String selectedMethod = "";
            for (JRadioButton button : buttons) {
                if (button.isSelected()) {
                    selectedMethod = button.getText();
                    break;
                }
            }
            paymentDialog.dispose();
            processOrder(total, itens, selectedMethod);
        });
        buttonPanel.add(confirmButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> paymentDialog.dispose());
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        paymentDialog.add(panel);
        paymentDialog.setVisible(true);
    }

    private void processOrder(float total, List<Item_carrinho> itens, String paymentMethod) {
        try {
            // Criar pedido
            Pedido pedido = new Pedido(
                0, // cod_pedido será gerado pelo banco
                codClienteAtual,
                0.0f, // desconto
                0.0f, // valor_frete
                total, // subtotal
                total, // valor_total
                "Pendente" // status
            );

            if (pedidoDAO.criarPedido(pedido)) {
                // Criar pagamento
                Pagamento pagamento = new Pagamento(
                    0, // cod_pagamento será gerado pelo banco
                    pedido.getCod_pedido(),
                    total,
                    paymentMethod,
                    "Pendente"
                );

                if (pagamentoDAO.registrarPagamento(pagamento)) {
                    // Limpar carrinho
                    carrinhoDAO.deletarCarrinho(codClienteAtual);
                    
                    // Mostrar detalhes do pedido
                    showOrderDetails(pedido, pagamento, itens);
                } else {
                    throw new Exception("Erro ao registrar pagamento");
                }
            } else {
                throw new Exception("Erro ao criar pedido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao processar pedido: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showOrderDetails(Pedido pedido, Pagamento pagamento, List<Item_carrinho> itens) {
        JDialog detailsDialog = new JDialog(this, "Detalhes do Pedido", true);
        detailsDialog.setSize(500, 600);
        detailsDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Pedido Realizado com Sucesso!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Detalhes do pedido
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        detailsPanel.add(new JLabel("Número do Pedido: " + pedido.getCod_pedido()));
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(new JLabel("Status: " + pedido.getStatus()));
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(new JLabel("Forma de Pagamento: " + pagamento.getForma_pagamento()));
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(new JLabel("Status do Pagamento: " + pagamento.getStatus()));
        detailsPanel.add(Box.createVerticalStrut(20));

        // Itens do pedido
        detailsPanel.add(new JLabel("Itens do Pedido:", JLabel.LEFT));
        detailsPanel.add(Box.createVerticalStrut(10));

        for (Item_carrinho item : itens) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            itemPanel.add(new JLabel(item.getNome_livro() + " x" + item.getQuantidade()));
            itemPanel.add(new JLabel(String.format("R$ %.2f", item.getPreco() * item.getQuantidade())));
            detailsPanel.add(itemPanel);
        }

        detailsPanel.add(Box.createVerticalStrut(20));
        detailsPanel.add(new JLabel(String.format("Total: R$ %.2f", pedido.getValor_total())));

        JScrollPane scrollPane = new JScrollPane(detailsPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão Fechar
        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> detailsDialog.dispose());
        panel.add(closeButton, BorderLayout.SOUTH);

        detailsDialog.add(panel);
        detailsDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CatalogoLivros().setVisible(true);
        });
    }
} 