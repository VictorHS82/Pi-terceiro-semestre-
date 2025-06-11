package interfacesDAO;

import java.util.List;

import objetos.Pagamento;

/**
 * Interface de pagamentoDAO 
 */
public interface BasePagamentoDAO {

	/**
	 * Método que registra um novo pagamento no banco de dados
	 * @param pagamento objeto pagamento a ser cadastrado
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean registrarPagamento(Pagamento pagamento);

	/**
	 * Lista todos os pagamentos disponiveis
	 * @return lista com todos os pagamentos do sistema
	 */
	List<Pagamento> listarPagamentos();

	/**
	 * Pega os dados de um pagamento com base no cod_pagamento fornecido 
	 * @param cod_pagamento código do pagamente a ser consultado
	 * @return objeto pagamento
	 */
	Pagamento getPagamento(int cod_pagamento);

	/**
	 * Atualiza o status do pagamento especificado
	 * @param cod_pagamento código do pagamento a ser atulizado
	 * @param novoStatus novo statsu a ser registrado no banco
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean atualizarStatus(int cod_pagamento, String novoStatus);

	/**
	 * Exclui um pagamento com base no codigo fornecido
	 * @param cod_pagamento código do pagamento a ser excluido
	 * @return boolean para sinalizar se foi bem sucedido
	 */
	boolean excluirPagamento(int cod_pagamento);

}