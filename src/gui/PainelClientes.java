package gui;

import banco_de_dados.ContasInfoDAO;
import objetos.Cliente;
import objetos.ContaInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PainelClientes extends JPanel {

    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelClientes() {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Email", "CPF", "Telefone", "Endereço"}, 0);
        tabela = new JTable(modelo);

        carregarClientes();

        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    private void carregarClientes() {
        ContasInfoDAO dao = new ContasInfoDAO();
        modelo.setRowCount(0); // limpar

        for (ContaInfo c : dao.listarTodasContas()) {
            modelo.addRow(new Object[]{
                c.getCod_usuario(), c.getNome(), c.getEmail(),
                c.getCpf(), c.getTelefone(), c.getEndereco()
            });
        }
    }
}
