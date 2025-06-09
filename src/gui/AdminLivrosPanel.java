package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import banco_de_dados.LivroDAO;
import objetos.Livros;

public class AdminLivrosPanel extends JPanel {
    private JTable tabela;
    private DefaultListModel<Livros> model;
    private LivroDAO livroDAO;

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

    private Object[][] carregarDados() {
        List<Livros> livros = livroDAO.listarTodos();
        Object[][] dados = new Object[livros.size()][5];
        for (int i = 0; i < livros.size(); i++) {
            Livros l = livros.get(i);
            dados[i][0] = l.getCod_livro();
            dados[i][1] = l.getTitulo();
            dados[i][2] = l.getAutor();
            dados[i][3] = l.getPrecoUnid();
            dados[i][4] = l.getQuantidade();
        }
        return dados;
    }

    private void adicionarLivro() {
        // Exibe formulário para adicionar livro
        JOptionPane.showMessageDialog(this, "Formulário de adição ainda não implementado.");
    }

    private void editarLivro() {
        // Lógica para editar o livro selecionado
        JOptionPane.showMessageDialog(this, "Função de edição ainda não implementada.");
    }

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
