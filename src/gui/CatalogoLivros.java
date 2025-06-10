package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import banco_de_dados.*;
import objetos.*;

public class CatalogoLivros extends JPanel {
    private final MainFrame mainFrame;
    private final LivroDAO livroDAO;
    private final CarrinhoDAO carrinhoDAO;
    private final PedidoDAO pedidoDAO;
    private final PagamentoDAO pagamentoDAO;
    private final int codClienteAtual;

    private JPanel panelCatalogo;

    public CatalogoLivros(MainFrame mainFrame, int codClienteAtual) {
        this.mainFrame = mainFrame;
        this.codClienteAtual = codClienteAtual;
        this.livroDAO = new LivroDAO();
        this.carrinhoDAO = new CarrinhoDAO();
        this.pedidoDAO = new PedidoDAO();
        this.pagamentoDAO = new PagamentoDAO();

        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        JLabel tituloLabel = new JLabel("Catálogo de Livros", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(tituloLabel, BorderLayout.NORTH);

        panelCatalogo = new JPanel();
        panelCatalogo.setLayout(new GridLayout(0, 3, 10, 10));
        JScrollPane scrollPane = new JScrollPane(panelCatalogo);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnCarrinho = new JButton("Carrinho de Compras");
        btnCarrinho.addActionListener(e -> mostrarCarrinho());
        add(btnCarrinho, BorderLayout.SOUTH);

        JButton btnAdmin = new JButton("Administração");
        btnAdmin.addActionListener(e -> mainFrame.mostrarPainelAdmin(codClienteAtual));
        add(btnAdmin, BorderLayout.EAST);

        carregarLivros();
    }

    private void carregarLivros() {
        panelCatalogo.removeAll();
        List<Livros> livros = livroDAO.listarTodos();

        for (Livros livro : livros) {
            JPanel panelLivro = criarPainelLivro(livro);
            panelCatalogo.add(panelLivro);
        }

        panelCatalogo.revalidate();
        panelCatalogo.repaint();
    }

    private JPanel criarPainelLivro(Livros livro) {
    JPanel panelLivro = new JPanel();
    panelLivro.setLayout(new BoxLayout(panelLivro, BoxLayout.Y_AXIS));
    panelLivro.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    panelLivro.setPreferredSize(new Dimension(200, 300));

    // Carregar imagem
    JLabel lblImagem;
    if (livro.getImagem() != null && !livro.getImagem().isEmpty()) {
        try {
            ImageIcon icon = new ImageIcon(livro.getImagem());
            Image img = icon.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            lblImagem = new JLabel(new ImageIcon(img));
        } catch (Exception e) {
            lblImagem = new JLabel("Sem imagem");
        }
    } else {
        lblImagem = new JLabel("Sem imagem");
    }

    JLabel lblTitulo = new JLabel("Título: " + livro.getTitulo());
    JLabel lblAutor = new JLabel("Autor: " + livro.getAutor());
    JLabel lblPreco = new JLabel("Preço: R$" + livro.getPreco_unitario());
    JLabel lblEstoque = new JLabel("Estoque: " + livro.getQuantidade());
    JButton btnAdicionar = new JButton("Adicionar ao Carrinho");
    btnAdicionar.addActionListener(e -> {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        DetalhesLivroDialog dialog = new DetalhesLivroDialog(parentFrame, livro, carrinhoDAO, codClienteAtual);
        dialog.setVisible(true);
    });


    panelLivro.add(lblImagem);
    panelLivro.add(lblTitulo);
    panelLivro.add(lblAutor);
    panelLivro.add(lblPreco);
    panelLivro.add(lblEstoque);
    panelLivro.add(btnAdicionar);

    return panelLivro;
}

    // private void adicionarAoCarrinho(Livros livro) {
    //     Item_carrinho item = new Item_carrinho(0, 1, livro.getCod_livro(), livro.getTitulo(), 1, livro.getPreco_unitario());
    //     carrinhoDAO.post(item);
    //     JOptionPane.showMessageDialog(this, "Livro adicionado ao carrinho.");
    // }

    private void mostrarCarrinho() {
        List<Item_carrinho> itens = carrinhoDAO.get(1);
        StringBuilder sb = new StringBuilder();
        double total = 0;

        for (Item_carrinho item : itens) {
            Livros livro = livroDAO.buscarPorCodigo(item.getCod_livro());
            double subtotal = livro.getPreco_unitario() * item.getQuantidade();
            total += subtotal;
            sb.append(livro.getTitulo())
              .append(" - Quantidade: ").append(item.getQuantidade())
              .append(" - Preço: R$").append(subtotal).append("\n");
        }

        sb.append("\nTotal: R$").append(total);

        int opcao = JOptionPane.showConfirmDialog(this, sb.toString(), "Carrinho de Compras", JOptionPane.OK_CANCEL_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            escolherFormaPagamento(itens, total);
        }
    }

    private void escolherFormaPagamento(List<Item_carrinho> itens, double total) {
        String[] opcoes = {"PIX", "Cartão de Crédito", "Boleto Bancário"};
        int escolha = JOptionPane.showOptionDialog(this, "Escolha a forma de pagamento:", "Pagamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha >= 0) {
            String formaPagamento = opcoes[escolha];
            confirmarPedido(itens, total, formaPagamento);
        }
    }

  private void confirmarPedido(List<Item_carrinho> itens, double total, String formaPagamento) {
    // Cria o pedido
    Pedido pedido = new Pedido(0, codClienteAtual, 0f, 0f, (float) total, (float) total, "Pendente");
    boolean pedidoCriado = pedidoDAO.criarPedido(pedido);

    if (!pedidoCriado) {
        JOptionPane.showMessageDialog(this, "Erro ao criar pedido.");
        return;
    }

    // Recupera o código do pedido recém-criado (ajuste conforme sua implementação)
    int codPedido = pedido.getCod_pedido();

    // Para cada item do carrinho, cria um item_pedido e adiciona ao pedido
    for (Item_carrinho itemCarrinho : itens) {
        Item_pedido itemPedido = new Item_pedido(
            0, // cod_item_pedido (auto-incremento)
            codPedido,
            itemCarrinho.getCod_livro(),
            itemCarrinho.getQuantidade(),
            itemCarrinho.getPreco()
        );
        pedidoDAO.adicionarItemPedido(itemPedido);
    }

    // Registra o pagamento
    Pagamento pagamento = new Pagamento(0, codPedido,  (float) total, formaPagamento, "Confirmado");
    pagamentoDAO.registrarPagamento(pagamento);

    // Limpa o carrinho do usuário
    carrinhoDAO.deletarCarrinho(codClienteAtual);

    JOptionPane.showMessageDialog(this, "Pedido confirmado com sucesso!");
  }
}
