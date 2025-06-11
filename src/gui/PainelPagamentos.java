package gui;

import banco_de_dados.PagamentoDAO;
import interfacesDAO.BasePagamentoDAO;
import objetos.Pagamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Classe que modela o painel de pagamentos relacionada ao painel administrativa
 */
public class PainelPagamentos extends JPanel {

    private JTable tabela;
    private DefaultTableModel modelo;

    /**
     * Método quê modela o painel pagamentos
     */
    public PainelPagamentos() {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{
            "ID", "Pedido", "Valor", "Forma Pagamento", "Status"
        }, 0);

        tabela = new JTable(modelo);
        carregarPagamentos();

        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    /**
     * Método para carregar as informações de pagamento
     */
    private void carregarPagamentos() {
        BasePagamentoDAO dao = new PagamentoDAO();
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
