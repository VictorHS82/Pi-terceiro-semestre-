package interfacesDAO;

import java.util.List;

import objetos.Pagamento;

public interface BasePagamentoDAO {

	/**
	 * Método que registra um novo pagamento no banco de dados
	 * @param pagamento
	 * @return boolean
	 */
	boolean registrarPagamento(Pagamento pagamento);

	/**
	 * Lista todos os pagamentos disponiveis
	 * @return list
	 */
	List<Pagamento> listarPagamentos();

	/**
	 * Pega os dados de um pagamento com base no cod_pagamento fornecido 
	 * @param cod_pagamento
	 * @return objeto pagamento
	 */
	Pagamento getPagamento(int cod_pagamento);

	/**
	 * Atualiza o status do pagamento especificado
	 * @param cod_pagamento
	 * @param novoStatus
	 * @return boolean
	 */
	boolean atualizarStatus(int cod_pagamento, String novoStatus);

	/**
	 * Exclui um pagamento com base no codigo fornecido
	 * @param cod_pagamento
	 * @return boolean
	 */
	boolean excluirPagamento(int cod_pagamento);

}