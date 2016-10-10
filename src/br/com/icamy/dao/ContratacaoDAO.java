package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Contratacao;
import br.com.icamy.factory.ConnectionFactory;

public class ContratacaoDAO {
	private Connection conexao;

	public ContratacaoDAO() throws Exception {
		try {
			this.conexao = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public int insert(Contratacao contratacao) throws Exception {
		PreparedStatement statement = null;
		String sql = "INSERT INTO t_icm_contratacao (cd_oferta, cd_cliente, vl_contratacao, st_contratacao) "
					+ "VALUES (?, ?, ?, ?)";
		try {
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, contratacao.getOferta().getCodigo());
			statement.setInt(2, contratacao.getCliente().getCodigo());
			statement.setDouble(3, contratacao.getValor());
			statement.setInt(4, 1);
			int result = statement.executeUpdate();

			if (result > 0)
				return result;
			else
				throw new Exception("Erro ao retornar o novo registro");
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (RuntimeException e) {
				throw new Exception(e);
			}
		}
	}
	
	public int selectMaxCodigo() throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		int codigo = 0;
		String sql = "SELECT cd_contratacao FROM t_icm_contratacao ORDER BY cd_contratacao DESC LIMIT 1";
		try {
			statement = conexao.prepareStatement(sql);
			result = statement.executeQuery();
			
			if (result.next()) {
				codigo = result.getInt("cd_contratacao");
			} else {
				throw new Exception("Registro não encontrado");
			}
			return codigo;
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				result.close();
				statement.close();
				conexao.close();
			} catch(RuntimeException e) {
				throw new Exception(e);
			}
		}
	}

}
