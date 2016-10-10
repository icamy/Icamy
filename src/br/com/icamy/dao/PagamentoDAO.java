package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.icamy.beans.Pagamento;
import br.com.icamy.factory.ConnectionFactory;

public class PagamentoDAO {
	private Connection connection;

	public PagamentoDAO() throws Exception {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	public int insert(Pagamento pagamento) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "INSERT INTO t_icm_pagamento ("
					+ "cd_contratacao, cd_modalidade, vl_operacao, st_pagameento, cd_identificador"
					+ ") VALUES (?, ?, ?, ?, ?)";

		try {
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, pagamento.getContratacao().getCodigo());
			statement.setInt(2, pagamento.getModalidadePgto().getCodigo());
			statement.setDouble(3, pagamento.getValor());
			statement.setInt(4, 1);
			statement.setString(5, pagamento.getCodigoIdentificador());

			result = statement.getGeneratedKeys();

			if (result.next())
				return result.getInt(1);
			else
				throw new Exception("Erro ao retornar o novo registro");
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (RuntimeException e) {
				throw new Exception(e);
			}
		}
	}

}
