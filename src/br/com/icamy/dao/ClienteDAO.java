package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.icamy.beans.Cliente;
import br.com.icamy.factory.ConnectionFactory;

public class ClienteDAO {
	private Connection conexao;

	public ClienteDAO() throws Exception {
		try {
			this.conexao = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public Cliente selectWhereCliente(int codigo) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			String sql = "SELECT cd_cliente, nm_cliente, ds_email FROM t_icm_cliente WHERE cd_cliente=?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, codigo);
			result = statement.executeQuery();
			
			Cliente cliente = new Cliente();
			
			while(result.next()) {
				cliente.setCodigo(result.getInt("cd_cliente"));
				cliente.setNome(result.getString("nm_cliente"));
				cliente.setEmail(result.getString("ds_email"));
			}
			
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (conexao != null)
				try {
					result.close();
					statement.close();
					conexao.close();
				} catch (RuntimeException e) {
					e.printStackTrace();
					throw new Exception(e);
				}
		}
	}
}
