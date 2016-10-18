package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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
	
	public Cliente login(Map<String, String> usuario) throws Exception {
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			String sql = "select * from t_icm_cliente where ds_email = ? and ds_senha = ? limit 1;";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.get("email"));
			stmt.setString(2, usuario.get("senha"));
			result = stmt.executeQuery();
			
			if (result.next()) {
				return new Cliente(result.getInt("cd_cliente"), result.getString("nm_cliente"), result.getLong("nr_telefone"),
						result.getString("ds_email"), result.getString("ds_senha"), result.getString("dt_nascimento"),
						result.getString("ds_url_foto"), result.getLong("nr_cpf"), result.getString("ds_sexo").charAt(0), null);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				result.close();
				stmt.close();
				conexao.close();
			} catch(RuntimeException e) {
				throw new Exception(e);
			}
		}
	}
}
