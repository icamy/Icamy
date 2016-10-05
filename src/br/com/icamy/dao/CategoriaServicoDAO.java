package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.factory.ConnectionFactory;

public class CategoriaServicoDAO {
	private Connection connection;

	public CategoriaServicoDAO() throws Exception {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public List<CategoriaServico> getAll() throws Exception {
		List<CategoriaServico> categorias = new ArrayList<CategoriaServico>();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			String sql = "select cd_categoria, nm_categoria from t_icm_categoria";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next()) {
				categorias.add(new CategoriaServico(result.getInt("cd_categoria"), result.getString("nm_categoria")));
			}
			
			return categorias;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (connection != null)
				try {
					result.close();
					statement.close();
					connection.close();
				} catch (RuntimeException e) {
					e.printStackTrace();
					throw new Exception(e);
				}
		}
	}
}
