package gui;

import banco_de_dados.ContasInfoDAO;
import interfacesDAO.BaseContasInfoDAO;
import objetos.ContaInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Classe que modela o Painel conta da área administrativa
 */
public class PainelContas extends JPanel {

    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelContas() {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(
            new Object[]{"Tipo", "ID", "Nome", "Email", "Telefone", "Endereço", "Criado Por"}, 0
        );

        tabela = new JTable(modelo);
        carregarContas();

        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    /**
     * Carrega as informações de contas
     */
    private void carregarContas() {
        BaseContasInfoDAO dao = new ContasInfoDAO();
        List<ContaInfo> contas = dao.listarTodasContas();

        modelo.setRowCount(0); // limpar

        for (ContaInfo conta : contas) {
            modelo.addRow(new Object[]{
                conta.getTipoConta(),
                conta.getId(),
                conta.getNome(),
                conta.getEmail(),
                conta.getTelefone(),
                conta.getEndereco(),
                conta.getCriadoPor() != null ? conta.getCriadoPor() : "-"
            });
        }
    }
}
