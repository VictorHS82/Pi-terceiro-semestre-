package gui;

import banco_de_dados.PedidoDAO;
import interfacesDAO.BasePedidoDAO;
import objetos.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Classe que modela o painel pedidos da tela de Administrador
 */
public class PainelPedidos extends JPanel {

    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelPedidos() {
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{
            "ID", "Cliente", "Desconto", "Frete", "Subtotal", "Total", "Status"
        }, 0);

        tabela = new JTable(modelo);
        carregarPedidos();

        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    /**
     * Método que carrega as informações dos pedidos
     */
    private void carregarPedidos() {
        BasePedidoDAO dao = new PedidoDAO();
        modelo.setRowCount(0);

        List<Pedido> pedidos = dao.listarTodosPedidos();
        for (Pedido p : pedidos) {
            modelo.addRow(new Object[]{
                p.getCod_pedido(), p.getCod_cliente(), p.getDesconto(),
                p.getValor_frete(), p.getSubtotal(), p.getValor_total(),
                p.getStatus()
            });
        }
    }
}
