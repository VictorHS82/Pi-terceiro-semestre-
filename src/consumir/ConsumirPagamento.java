package consumir;

import banco_de_dados.PagamentoDAO;
import objetos.Pagamento;

public class ConsumirPagamento {

    public static void main(String[] args) {
        // Descomente o(s) teste(s) que deseja rodar
        //inserirPagamento();
         //buscarPagamento();
        atualizarStatusPagamento();
    }

    public static void inserirPagamento() {
        Pagamento pagamento = new Pagamento(
            89,                  // cod_pagamento
            8,                  // cod_pedido
            105.0f,             // valor_compra
            "Cartão de Crédito",// forma_pagamento
            "Pago"        // status
        );

        PagamentoDAO dao = new PagamentoDAO();
        boolean sucesso = dao.registrarPagamento(pagamento);
        System.out.println("Pagamento inserido? " + sucesso);
    }

    public static void buscarPagamento() {
        PagamentoDAO dao = new PagamentoDAO();
        Pagamento pagamento = dao.getPagamento(89); // cod_pagamento

        if (pagamento != null) {
            System.out.println("Pagamento encontrado:");
            System.out.println("Código: " + pagamento.getCod_pagamento());
            System.out.println("Valor: R$ " + pagamento.getValor_compra());
            System.out.println("Forma: " + pagamento.getForma_pagamento());
            System.out.println("Status: " + pagamento.getStatus());
        } else {
            System.out.println("Pagamento não encontrado.");
        }
    }

    public static void atualizarStatusPagamento() {
        PagamentoDAO dao = new PagamentoDAO();
        boolean atualizado = dao.atualizarStatus(89, "Falhou");
        System.out.println("Status atualizado? " + atualizado);
    }
}
