package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import banco_de_dados.*;
import interfacesDAO.BaseLivroDAO;
import objetos.Livros;

/**
 * Classe para a tela de Administrador
 */
@SuppressWarnings("serial")
public class AdminLivrosPanel extends JPanel {
    /**
     * Recebe um obbjeto JTbable   
     */
	private JTable tabela;
	/**
	 * Recebe lista de livros
	 */
    private DefaultListModel<Livros> model;
    /**
     * Recebe um livroDAO
     */
    private BaseLivroDAO livroDAO;

    /**
     * Inicia painel admin livros
     */
    public AdminLivrosPanel() {
        setLayout(new BorderLayout());
        livroDAO = new LivroDAO();

        String[] colunas = {"ID", "Título", "Autor", "Preço", "Estoque"};
        Object[][] dados = carregarDados();

        tabela = new JTable(dados, colunas);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel botoes = new JPanel();

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(e -> adicionarLivro());
        botoes.add(btnAdicionar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> editarLivro());
        botoes.add(btnEditar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> excluirLivro());
        botoes.add(btnExcluir);

        add(botoes, BorderLayout.SOUTH);
    }

    /**
     * Classe que carrega os livros na tela
     * @return informações dos livros
     */
    private Object[][] carregarDados() {
        List<Livros> livros = livroDAO.listarTodos();
        Object[][] dados = new Object[livros.size()][5];
        for (int i = 0; i < livros.size(); i++) {
            Livros l = livros.get(i);
            dados[i][0] = l.getCod_livro();
            dados[i][1] = l.getTitulo();
            dados[i][2] = l.getAutor();
            dados[i][3] = l.getPreco_unitario();
            dados[i][4] = l.getQuantidade();
        }
        return dados;
    }

    /**
     * Classe da interface gráfica para adiconar um novo livro ao banco
     */
private void adicionarLivro() {
    JTextField tituloField = new JTextField();
    JTextField autorField = new JTextField();
    JTextField descricaoField = new JTextField();
    JTextField anoField = new JTextField();
    JTextField isbnField = new JTextField();
    JTextField generoField = new JTextField();
    JTextField idiomaField = new JTextField();
    JTextField formatoField = new JTextField();
    JTextField paginasField = new JTextField();
    JTextField estoqueField = new JTextField();
    JTextField pesoField = new JTextField();
    JTextField precoField = new JTextField();
    JTextField imagemField = new JTextField();

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Título:"));
    panel.add(tituloField);
    panel.add(new JLabel("Autor:"));
    panel.add(autorField);
    panel.add(new JLabel("Descrição:"));
    panel.add(descricaoField);
    panel.add(new JLabel("Ano de Publicação:"));
    panel.add(anoField);
    panel.add(new JLabel("ISBN:"));
    panel.add(isbnField);
    panel.add(new JLabel("Gênero:"));
    panel.add(generoField);
    panel.add(new JLabel("Idioma:"));
    panel.add(idiomaField);
    panel.add(new JLabel("Formato:"));
    panel.add(formatoField);
    panel.add(new JLabel("Páginas:"));
    panel.add(paginasField);
    panel.add(new JLabel("Estoque:"));
    panel.add(estoqueField);
    panel.add(new JLabel("Peso (g):"));
    panel.add(pesoField);
    panel.add(new JLabel("Preço:"));
    panel.add(precoField);
    panel.add(new JLabel("Imagem (URL ou caminho):"));
    panel.add(imagemField);

    int result = JOptionPane.showConfirmDialog(this, panel, "Adicionar Livro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        try {
            Livros novoLivro = new Livros(
                0,
                tituloField.getText(),
                autorField.getText(),
                descricaoField.getText(),
                anoField.getText(),
                isbnField.getText(),
                generoField.getText(),
                idiomaField.getText(),
                formatoField.getText(),
                Integer.parseInt(paginasField.getText()),
                Integer.parseInt(estoqueField.getText()),
                Float.parseFloat(pesoField.getText()),
                Float.parseFloat(precoField.getText()),
                imagemField.getText()
            );
            livroDAO.cadastrarLivro(novoLivro);
            JOptionPane.showMessageDialog(this, "Livro adicionado com sucesso!");
            atualizarTabela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
        }
    }
}

/**
 * Classe para editar um livro através da onterface gráfica
 */
private void editarLivro() {
    int selectedRow = tabela.getSelectedRow();
    if (selectedRow >= 0) {
        int id = (int) tabela.getValueAt(selectedRow, 0);
        Livros livroAtual = livroDAO.buscarPorCodigo(id);

        JTextField tituloField = new JTextField(livroAtual.getTitulo());
        JTextField autorField = new JTextField(livroAtual.getAutor());
        JTextField descricaoField = new JTextField(livroAtual.getDescricao());
        JTextField anoField = new JTextField(livroAtual.getAnopublicacao());
        JTextField isbnField = new JTextField(livroAtual.getIsbn());
        JTextField generoField = new JTextField(livroAtual.getGenero());
        JTextField idiomaField = new JTextField(livroAtual.getIdioma());
        JTextField formatoField = new JTextField(livroAtual.getFormato());
        JTextField paginasField = new JTextField(String.valueOf(livroAtual.getPaginas()));
        JTextField estoqueField = new JTextField(String.valueOf(livroAtual.getQuantidade()));
        JTextField pesoField = new JTextField(String.valueOf(livroAtual.getPeso()));
        JTextField precoField = new JTextField(String.valueOf(livroAtual.getPreco_unitario()));
        JTextField imagemField = new JTextField(livroAtual.getImagem());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Título:"));
        panel.add(tituloField);
        panel.add(new JLabel("Autor:"));
        panel.add(autorField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Ano de Publicação:"));
        panel.add(anoField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel("Gênero:"));
        panel.add(generoField);
        panel.add(new JLabel("Idioma:"));
        panel.add(idiomaField);
        panel.add(new JLabel("Formato:"));
        panel.add(formatoField);
        panel.add(new JLabel("Páginas:"));
        panel.add(paginasField);
        panel.add(new JLabel("Estoque:"));
        panel.add(estoqueField);
        panel.add(new JLabel("Peso (g):"));
        panel.add(pesoField);
        panel.add(new JLabel("Preço:"));
        panel.add(precoField);
        panel.add(new JLabel("Imagem (URL ou caminho):"));
        panel.add(imagemField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Editar Livro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                Livros livroEditado = new Livros(
                    id,
                    tituloField.getText(),
                    autorField.getText(),
                    descricaoField.getText(),
                    anoField.getText(),
                    isbnField.getText(),
                    generoField.getText(),
                    idiomaField.getText(),
                    formatoField.getText(),
                    Integer.parseInt(paginasField.getText()),
                    Integer.parseInt(estoqueField.getText()),
                    Float.parseFloat(pesoField.getText()),
                    Float.parseFloat(precoField.getText()),
                    imagemField.getText()
                );
                livroDAO.atualizarLivro(livroEditado);
                JOptionPane.showMessageDialog(this, "Livro editado com sucesso!");
                atualizarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos!");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um livro para editar.");
    }
}

/**
 * Atualiza a tabela depois de atualizar/editar/excluir umm livro
 */
private void atualizarTabela() {
    removeAll();
    String[] colunas = {"ID", "Título", "Autor", "Preço", "Estoque"};
    Object[][] dados = carregarDados();
    tabela = new JTable(dados, colunas);
    add(new JScrollPane(tabela), BorderLayout.CENTER);

    JPanel botoes = new JPanel();

    JButton btnAdicionar = new JButton("Adicionar");
    btnAdicionar.addActionListener(e -> adicionarLivro());
    botoes.add(btnAdicionar);

    JButton btnEditar = new JButton("Editar");
    btnEditar.addActionListener(e -> editarLivro());
    botoes.add(btnEditar);

    JButton btnExcluir = new JButton("Excluir");
    btnExcluir.addActionListener(e -> excluirLivro());
    botoes.add(btnExcluir);

    add(botoes, BorderLayout.SOUTH);

    revalidate();
    repaint();
}

/**
 * Exclui um livro 
 */
    private void excluirLivro() {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tabela.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja excluir o livro ID " + id + "?");
            if (confirm == JOptionPane.YES_OPTION) {
                if (livroDAO.deletarLivro(id)) {
                    JOptionPane.showMessageDialog(this, "Livro excluído.");
                    removeAll();
                    revalidate();
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir livro.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um livro para excluir.");
        }
    }
}
