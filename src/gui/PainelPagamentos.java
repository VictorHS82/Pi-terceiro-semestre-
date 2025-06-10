package gui;

import banco_de_dados.PagamentoDAO;
import objetos.Pagamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PainelPagamentos extends JPanel {

    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelPagamentos() {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{
            "ID", "Pedido", "Valor", "Forma Pagamento", "Status"
        }, 0);

        tabela = new JTable(modelo);
        carregarPagamentos();

        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    private void carregarPagamentos() {
        PagamentoDAO dao = new PagamentoDAO();
        modelo.setRowCount(0);

        List<Pagamento> pagamentos = dao.listarPagamentos();
        for (Pagamento p : pagamentos) {
            modelo.addRow(new Object[]{
                p.getCod_pagamento(), p.getCod_pedido(),
                p.getValor_compra(), p.getForma_pagamento(),
                p.getStatus()
            });
        }
    }
}
