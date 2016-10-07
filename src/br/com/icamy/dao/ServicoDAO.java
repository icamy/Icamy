package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Servico;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;
import br.com.icamy.factory.ConnectionFactory;

public class ServicoDAO {
	private Connection connection;
	
	public ServicoDAO() throws Exception {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	public int insert(Servico servico) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "insert into t_icm_servico (cd_categoria, nm_servico, ds_servico) values (?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, servico.getCategoriaServico().getCodigo());
			statement.setString(2, servico.getNome());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();

			if (result.next())
				return result.getInt(1);
			else
				throw new Exception("Erro ao retornar o registro gerado.");
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

	public int update(Servico servico) throws Exception {
		PreparedStatement statement = null;

		try {
			String sql = "update t_icm_servico set cd_categoria = ?, nm_servico = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, servico.getCategoriaServico().getCodigo());
			statement.setString(2, servico.getNome());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (RuntimeException e) {
				throw new Exception(e);
			}
		}
	}

	public int delete(Servico servico) throws Exception {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("delete from t_icm_servico where cd_servico = ?");
			statement.setInt(1, servico.getCodigo());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (RuntimeException e) {
				throw new Exception(e);
			}
		}
	}

	public Servico get(int codigo) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			statement = connection.prepareStatement(
					"select cd_servico, cd_categoria, nm_categoria, nm_servico, st_servico, ds_servico from t_icm_servico "
							+ "natural join t_icm_categoria where cd_servico = ?");
			statement.setInt(1, codigo);
			result = statement.executeQuery();

			if (result.next()) {
				Servico servico = new Servico();
				servico.setCodigo(result.getInt("cd_servico"));
				servico.setCategoriaServico(new CategoriaServico());
				servico.getCategoriaServico().setCodigo(result.getInt("cd_categoria"));
				servico.getCategoriaServico().setNome(result.getString("nm_categoria"));
				servico.setNome(result.getString("nm_servico"));
				servico.setStatus(result.getString("st_servico").charAt(0));

				return servico;
			} else {
				throw new RegistroNaoEncontradoException("Nenhum registro foi encontrado");
			}
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

	public List<Servico> getAll() throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Servico> lstServicos = new ArrayList<Servico>();

		try {
			String sql = "SELECT * FROM t_icm_servico "
						+ "NATURAL JOIN t_icm_categoria_servico";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();

			while (result.next()) {
				Servico servico = new Servico();
				servico.setCodigo(result.getInt("cd_servico"));
				servico.setCategoriaServico(new CategoriaServico());
				servico.getCategoriaServico().setCodigo(result.getInt("cd_categoria"));
				servico.getCategoriaServico().setNome(result.getString("nm_categoria"));
				servico.setNome(result.getString("nm_servico"));
				servico.setStatus(result.getString("st_servico").charAt(0));

				lstServicos.add(servico);
			}

			return lstServicos;
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
	
 	public List<Servico> getServicosDoTipo(int cdCategoria) throws Exception {
 		List<Servico> servicos = new ArrayList<Servico>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "";
		
		try {
			sql += "select * from t_icm_servico ";
			sql += "natural join t_icm_categoria ";
			sql += "where cd_categoria = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cdCategoria);
			
			result = statement.executeQuery();
			
			while (result.next()) {
				servicos.add(new Servico(result.getInt("cd_servico"), new CategoriaServico(result.getInt("cd_categoria"),
					result.getString("nm_categoria")), result.getString("nm_servico"), result.getString("st_servico").charAt(0)));
			}
			
			return servicos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch(RuntimeException e) {
				e.printStackTrace();
				throw new Exception(e);
			}
		}
	}
}