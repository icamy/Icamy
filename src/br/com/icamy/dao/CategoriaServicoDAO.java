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
	private Connection conexao;

	public CategoriaServicoDAO() throws Exception {
		try {
			this.conexao = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public List<CategoriaServico> getAll() throws Exception {
		List<CategoriaServico> lstCategorias = new ArrayList<CategoriaServico>();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			String sql = "SELECT cd_categoria, nm_categoria FROM t_icm_categoria";
			statement = conexao.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next()) {
				lstCategorias.add(new CategoriaServico(result.getInt("cd_categoria"), result.getString("nm_categoria")));
			}
			
			return lstCategorias;
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
