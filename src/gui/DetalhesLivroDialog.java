package gui;

import objetos.Livros;
import objetos.Item_carrinho;

import javax.swing.*;

import interfacesDAO.BaseCarrinhoDAO;

import java.awt.*;

/**
 * Classe que modela detalhes do livro
 */
public class DetalhesLivroDialog extends JDialog {
	/**
	 * Constructor de DatelhesLivroDialog
	 * @param parent classe a ser usada
	 * @param livro objeto livro
	 * @param carrinhoDAO objeto CarrinhoDAO
	 * @param codClienteAtual código do cliennte na sessão atual
	 */
    public DetalhesLivroDialog(JFrame parent, Livros livro, BaseCarrinhoDAO carrinhoDAO, int codClienteAtual) {
        super(parent, "Detalhes do Livro", true);
        setLayout(new BorderLayout());

        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));

        // Imagem
        if (livro.getImagem() != null && !livro.getImagem().isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(livro.getImagem());
                Image img = icon.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH);
                panelInfo.add(new JLabel(new ImageIcon(img)));
            } catch (Exception e) {
                panelInfo.add(new JLabel("Sem imagem"));
            }
        } else {
            panelInfo.add(new JLabel("Sem imagem"));
        }

        panelInfo.add(new JLabel("Título: " + livro.getTitulo()));
        panelInfo.add(new JLabel("Autor: " + livro.getAutor()));
        panelInfo.add(new JLabel("Descrição: " + livro.getDescricao()));
        panelInfo.add(new JLabel("Ano: " + livro.getAnopublicacao()));
        panelInfo.add(new JLabel("ISBN: " + livro.getIsbn()));
        panelInfo.add(new JLabel("Gênero: " + livro.getGenero()));
        panelInfo.add(new JLabel("Idioma: " + livro.getIdioma()));
        panelInfo.add(new JLabel("Formato: " + livro.getFormato()));
        panelInfo.add(new JLabel("Páginas: " + livro.getPaginas()));
        panelInfo.add(new JLabel("Estoque: " + livro.getQuantidade()));
        panelInfo.add(new JLabel("Peso: " + livro.getPeso() + "g"));
        panelInfo.add(new JLabel("Preço: R$" + livro.getPreco_unitario()));

        add(panelInfo, BorderLayout.CENTER);

        JPanel panelAcoes = new JPanel();
        panelAcoes.setLayout(new FlowLayout());

        panelAcoes.add(new JLabel("Quantidade:"));
        JSpinner spinnerQtd = new JSpinner(new SpinnerNumberModel(1, 1, livro.getQuantidade(), 1));
        panelAcoes.add(spinnerQtd);

        JButton btnAdicionar = new JButton("Adicionar ao Carrinho");
        JButton btnCancelar = new JButton("Cancelar");

        btnAdicionar.addActionListener(e -> {
            int qtd = (int) spinnerQtd.getValue();
            Item_carrinho item = new Item_carrinho(0, codClienteAtual, livro.getCod_livro(), livro.getTitulo(), qtd, livro.getPreco_unitario());
            carrinhoDAO.post(item);
            JOptionPane.showMessageDialog(this, "Livro adicionado ao carrinho.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        panelAcoes.add(btnAdicionar);
        panelAcoes.add(btnCancelar);

        add(panelAcoes, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }
}