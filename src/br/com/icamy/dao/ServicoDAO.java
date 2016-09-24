package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "insert into servico (nm_servico, ds_servico) values (?,?);";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, servico.getNome());
			statement.setString(2, servico.getDescricao());
			statement.executeUpdate();
			result = statement.getGeneratedKeys();

			if (result.next())
				return result.getInt(1);
			else
				throw new Exception();
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new Exception(e);
			}
		}
	}

	public int update(Servico servico) throws Exception {
		PreparedStatement statement = null;

		try {
			String sql = "update servico set nm_servico = ?, ds_servico = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, servico.getNome());
			statement.setString(2, servico.getDescricao());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new Exception(e);
			}
		}
	}

	public int delete(Servico servico) throws Exception {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("delete from servico where cd_servico = ?");
			statement.setInt(1, servico.getCodigo());

			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new Exception(e);
			}
		}
	}

	public Servico get(int codigo) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			statement = connection.prepareStatement("select * from servico where cd_servico = ?");
			statement.setInt(1, codigo);
			result = statement.executeQuery();
			
			if (result.next()) {
				Servico servico = new Servico();
				servico.setCodigo(result.getInt("cd_servico"));
				servico.setNome(result.getString("nm_servico"));
				servico.setDescricao(result.getString("ds_servico"));
				servico.setStatus(result.getBoolean("st_servico"));
				
				return servico;
			} else {
				throw new RegistroNaoEncontradoException("Nenhum registro foi encontrado");
			}
		} catch(SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch(SQLException e) {
				throw new Exception(e);
			}
		}
	}

	public List<Servico> getAll() throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Servico> servicos = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement("select * from servico;");
			result = statement.executeQuery();
			
			while (result.next()) {
				Servico servico = new Servico();
				servico.setCodigo(result.getInt("cd_servico"));
				servico.setNome(result.getString("nm_servico"));
				servico.setDescricao(result.getString("ds_servico"));
				servico.setStatus(result.getBoolean("st_servico"));
				
				servicos.add(servico);
			}
			
			return servicos;
		} catch(SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch(SQLException e) {
				throw new Exception(e);
			}
		}
	}
}