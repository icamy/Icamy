package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Prestador;
import br.com.icamy.bo.ServicoBO;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;
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
	
	public List<CategoriaServico> selectAll() throws Exception {
		List<CategoriaServico> lstCategorias = new ArrayList<CategoriaServico>();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			String sql = "SELECT cd_categoria, nm_categoria FROM t_icm_categoria_servico";
			statement = conexao.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next()) {
				
				CategoriaServico categoria = new CategoriaServico();
				categoria.setCodigo(result.getInt("cd_ctegoria"));
				categoria.setNome(result.getString("nm_categoria"));
				lstCategorias.add(categoria);
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
	
	public CategoriaServico selectWhereCategoria(int cdCategoria) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			String sql = "SELECT * FROM  t_icm_categoria_servico "
						+ "WHERE cd_categoria = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, cdCategoria);
			result = statement.executeQuery();
			
			if (result.next()) {
				CategoriaServico categoria = new CategoriaServico();
				categoria.setCodigo(result.getInt("cd_categoria"));
				categoria.setNome(result.getString("nm_categoria"));
				categoria.setServico(new ServicoBO().getByCategoria(categoria.getCodigo()));
				return categoria;
			} else {
				throw new RegistroNaoEncontradoException("Registro não encontrado");
			}
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

	public List<CategoriaServico> selectWherePrestador(Prestador p) throws Exception {
		List<CategoriaServico> lstCategorias = new ArrayList<CategoriaServico>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT DISTINCT cd_categoria, nm_categoria, cd_prestador, nm_prestador "
					+ "FROM t_icm_categoria_servico "
					+ "INNER JOIN t_icm_servico USING (cd_categoria) "
					+ "INNER JOIN t_icm_oferta USING (cd_servico) "
					+ "INNER JOIN t_icm_prestador USING (cd_prestador) "
					+ "WHERE cd_prestador=?";
		try {
			
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, p.getCodigo());
			result = statement.executeQuery();
			
			while(result.next()) {
				CategoriaServico categoria = new CategoriaServico();
				categoria.setCodigo(result.getInt("cd_categoria"));
				categoria.setNome(result.getString("nm_categoria"));
				lstCategorias.add(categoria);
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
