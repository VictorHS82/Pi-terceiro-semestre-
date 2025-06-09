package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import banco_de_dados.*;
import objetos.*;

public class PainelAdministrativo extends JFrame {
    private LivroDAO livroDAO;
    private PedidoDAO pedidoDAO;
    private PagamentoDAO pagamentoDAO;
    private JTabbedPane tabbedPane;
    private static final int IMAGE_WIDTH = 100;
    private static final int IMAGE_HEIGHT = 150;

    public PainelAdministrativo() {
        livroDAO = new LivroDAO();
        pedidoDAO = new PedidoDAO();
        pagamentoDAO = new PagamentoDAO();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Painel Administrativo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        
        // Adiciona as abas
        tabbedPane.addTab("Livros", createLivrosPanel());
        tabbedPane.addTab("Pedidos", createPedidosPanel());
        tabbedPane.addTab("Pagamentos", createPagamentosPanel());

        add(tabbedPane);
    }

    private JPanel createLivrosPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tabela de livros com imagens
        String[] columnNames = {"Imagem", "Código", "Título", "Autor", "Preço", "Quantidade", "ISBN", "Gênero"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 0 ? ImageIcon.class : Object.class;
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(IMAGE_HEIGHT + 10);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botões de ação
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton addButton = new JButton("Adicionar Livro");
        addButton.addActionListener(e -> showAddEditBookDialog(null));
        
        JButton editButton = new JButton("Editar Livro");
        editButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int codLivro = (int) table.getValueAt(selectedRow, 1);
                Livros livro = livroDAO.buscarPorCodigo(codLivro);
                if (livro != null) {
                    showAddEditBookDialog(livro);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "Selecione um livro para editar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            }
        });
        
        JButton deleteButton = new JButton("Excluir Livro");
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int codLivro = (int) table.getValueAt(selectedRow, 1);
                int confirm = JOptionPane.showConfirmDialog(this,
                    "Deseja realmente excluir este livro?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    if (livroDAO.deletarLivro(String.valueOf(codLivro))) {
                        loadLivros(model);
                        JOptionPane.showMessageDialog(this,
                            "Livro excluído com sucesso!",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,
                            "Erro ao excluir livro",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "Selecione um livro para excluir",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Carrega os livros
        loadLivros(model);

        return panel;
    }

    private void loadLivros(DefaultTableModel model) {
        model.setRowCount(0);
        List<Livros> livros = livroDAO.listarTodos();
        for (Livros livro : livros) {
            ImageIcon imageIcon = loadBookImage(livro.getImagem());
            model.addRow(new Object[]{
                imageIcon,
                livro.getCod_livro(),
                livro.getTitulo(),
                livro.getAutor(),
                String.format("R$ %.2f", livro.getPrecoUnid()),
                livro.getQuantidade(),
                livro.getIsbn(),
                livro.getGenero()
            });
        }
    }

    private ImageIcon loadBookImage(String imagePath) {
        try {
            if (imagePath != null && !imagePath.trim().isEmpty()) {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    BufferedImage originalImage = ImageIO.read(imageFile);
                    BufferedImage resizedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = resizedImage.createGraphics();
                    g.drawImage(originalImage, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, null);
                    g.dispose();
                    return new ImageIcon(resizedImage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Retorna uma imagem padrão se não encontrar a imagem do livro
        return new ImageIcon(new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB));
    }

    private void showAddEditBookDialog(Livros livro) {
        JDialog dialog = new JDialog(this, livro == null ? "Adicionar Livro" : "Editar Livro", true);
        dialog.setSize(600, 700);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel para imagem
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        imagePanel.add(imageLabel);

        // Campos do formulário
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        
        JTextField tituloField = new JTextField();
        JTextField autorField = new JTextField();
        JTextField precoField = new JTextField();
        JTextField quantidadeField = new JTextField();
        JTextField isbnField = new JTextField();
        JTextField generoField = new JTextField();
        JTextField idiomaField = new JTextField();
        JTextField formatoField = new JTextField();
        JTextField paginasField = new JTextField();
        JTextField pesoField = new JTextField();
        JTextField imagemField = new JTextField();
        JTextArea descricaoArea = new JTextArea(3, 20);

        // Preenche os campos se estiver editando
        if (livro != null) {
            tituloField.setText(livro.getTitulo());
            autorField.setText(livro.getAutor());
            precoField.setText(String.valueOf(livro.getPrecoUnid()));
            quantidadeField.setText(String.valueOf(livro.getQuantidade()));
            isbnField.setText(livro.getIsbn());
            generoField.setText(livro.getGenero());
            idiomaField.setText(livro.getIdioma());
            formatoField.setText(livro.getFormato());
            paginasField.setText(String.valueOf(livro.getPaginas()));
            pesoField.setText(String.valueOf(livro.getPeso()));
            imagemField.setText(livro.getImagem());
            descricaoArea.setText(livro.getDescricao());
            
            // Carrega a imagem
            imageLabel.setIcon(loadBookImage(livro.getImagem()));
        }

        // Adiciona listener para atualizar a imagem quando o caminho for alterado
        imagemField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updateImage(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updateImage(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updateImage(); }
            
            private void updateImage() {
                imageLabel.setIcon(loadBookImage(imagemField.getText()));
            }
        });

        formPanel.add(new JLabel("Título:"));
        formPanel.add(tituloField);
        formPanel.add(new JLabel("Autor:"));
        formPanel.add(autorField);
        formPanel.add(new JLabel("Preço:"));
        formPanel.add(precoField);
        formPanel.add(new JLabel("Quantidade:"));
        formPanel.add(quantidadeField);
        formPanel.add(new JLabel("ISBN:"));
        formPanel.add(isbnField);
        formPanel.add(new JLabel("Gênero:"));
        formPanel.add(generoField);
        formPanel.add(new JLabel("Idioma:"));
        formPanel.add(idiomaField);
        formPanel.add(new JLabel("Formato:"));
        formPanel.add(formatoField);
        formPanel.add(new JLabel("Páginas:"));
        formPanel.add(paginasField);
        formPanel.add(new JLabel("Peso:"));
        formPanel.add(pesoField);
        formPanel.add(new JLabel("Imagem:"));
        formPanel.add(imagemField);
        formPanel.add(new JLabel("Descrição:"));
        formPanel.add(new JScrollPane(descricaoArea));

        panel.add(imagePanel, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(e -> {
            try {
                Livros novoLivro = new Livros(
                    livro != null ? livro.getCod_livro() : 0,
                    tituloField.getText(),
                    autorField.getText(),
                    descricaoArea.getText(),
                    "", // ano publicação
                    isbnField.getText(),
                    generoField.getText(),
                    idiomaField.getText(),
                    formatoField.getText(),
                    Integer.parseInt(paginasField.getText()),
                    Integer.parseInt(quantidadeField.getText()),
                    Float.parseFloat(pesoField.getText()),
                    Float.parseFloat(precoField.getText()),
                    imagemField.getText()
                );

                boolean success;
                if (livro == null) {
                    success = livroDAO.cadastrarLivro(novoLivro);
                } else {
                    success = livroDAO.atualizarLivro(novoLivro);
                }

                if (success) {
                    JOptionPane.showMessageDialog(dialog,
                        "Livro " + (livro == null ? "cadastrado" : "atualizado") + " com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    loadLivros((DefaultTableModel) ((JTable) ((JScrollPane) ((JPanel) tabbedPane.getComponentAt(0)).getComponent(0)).getViewport().getView()).getModel());
                } else {
                    JOptionPane.showMessageDialog(dialog,
                        "Erro ao " + (livro == null ? "cadastrar" : "atualizar") + " livro",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog,
                    "Por favor, preencha todos os campos numéricos corretamente",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private JPanel createPedidosPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tabela de pedidos
        String[] columnNames = {"Código", "Cliente", "Subtotal", "Total", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Carrega os pedidos
        List<Pedido> pedidos = pedidoDAO.listarTodos();
        for (Pedido pedido : pedidos) {
            model.addRow(new Object[]{
                pedido.getCod_pedido(),
                pedido.getCod_cliente(),
                String.format("R$ %.2f", pedido.getSubtotal()),
                String.format("R$ %.2f", pedido.getValor_total()),
                pedido.getStatus()
            });
        }

        return panel;
    }

    private JPanel createPagamentosPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tabela de pagamentos
        String[] columnNames = {"Código", "Pedido", "Valor", "Forma", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Carrega os pagamentos
        List<Pagamento> pagamentos = pagamentoDAO.listarPagamentos();
        for (Pagamento pagamento : pagamentos) {
            model.addRow(new Object[]{
                pagamento.getCod_pagamento(),
                pagamento.getCod_pedido(),
                String.format("R$ %.2f", pagamento.getValor_compra()),
                pagamento.getForma_pagamento(),
                pagamento.getStatus()
            });
        }

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PainelAdministrativo().setVisible(true);
        });
    }
}
