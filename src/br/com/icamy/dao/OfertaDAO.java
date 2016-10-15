package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Oferta;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;
import br.com.icamy.factory.ConnectionFactory;

public class OfertaDAO {
	private Connection connection;

	public OfertaDAO() throws Exception {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}

	public int insert(int cdPrestador, int cdServico, Oferta oferta) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "INSERT INTO t_icm_oferta ("
					+ "cd_servico, cd_prestador, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade"
					+ ") values (?, ?, ?, ?, ?, ?)";

		try {
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, cdServico);
			statement.setInt(2, cdPrestador);
			statement.setString(3, oferta.getDescricao());
			statement.setDouble(4, oferta.getValor());
			statement.setInt(5, oferta.getExecucaoEmMinutos());
			statement.setInt(6, oferta.getValidadeEmDias());

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
	
	public List<Oferta> selectAll() throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT cd_oferta, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade "
					+ "FROM  t_icm_oferta ";
		
		try {
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			List<Oferta> lstOfertas = new ArrayList<Oferta>();

			while (result.next()) {
				Oferta oferta = new Oferta();
				oferta.setCodigo(result.getInt("cd_oferta"));
				oferta.setDescricao(result.getString("tx_oferta"));
				oferta.setValor(result.getDouble("vl_oferta"));
				oferta.setExecucaoEmMinutos(result.getInt("nr_minutos_execucao"));
				oferta.setValidadeEmDias(result.getInt("nr_dias_validade"));

			}
			return lstOfertas;
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
	
	public Oferta selectWhereOferta(int cdOferta) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT cd_oferta, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade "
					+ "FROM  t_icm_oferta "
					+ "WHERE cd_oferta=?";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cdOferta);
			result = statement.executeQuery();
			
			if (result.next()) {
				
				Oferta oferta = new Oferta();
				oferta.setCodigo(result.getInt("cd_oferta"));
				oferta.setDescricao(result.getString("tx_oferta"));
				oferta.setValor(result.getDouble("vl_oferta"));
				oferta.setExecucaoEmMinutos(result.getInt("nr_minutos_execucao"));
				oferta.setValidadeEmDias(result.getInt("nr_dias_validade"));

				return oferta;
			} else {
				throw new RegistroNaoEncontradoException("Registro não encontrado");
			}
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			try {
				result.close();
				statement.close();
				connection.close();
			} catch(RuntimeException e) {
				throw new Exception(e);
			}
		}
	}
	
	public List<Oferta> selectWherePrestador(int cdPrestador) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "SELECT "
						+ "cd_oferta, nm_servico, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade, nm_categoria "
						+ "FROM  t_icm_oferta "
						+ "NATURAL JOIN t_icm_servico "
						+ "NATURAL JOIN t_icm_categoria_servico "
						+ "NATURAL JOIN t_icm_prestador "
						+ "WHERE cd_prestador = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cdPrestador);
			result = statement.executeQuery();
			List<Oferta> lstOfertas = new ArrayList<Oferta>();

			while (result.next()) {
				
				Oferta oferta = new Oferta();
				oferta.setCodigo(result.getInt("cd_oferta"));
				oferta.setTitulo(result.getString("nm_servico"));
				oferta.setDescricao(result.getString("tx_oferta"));
				oferta.setValor(result.getDouble("vl_oferta"));
				oferta.setExecucaoEmMinutos(result.getInt("nr_minutos_execucao"));
				oferta.setValidadeEmDias(result.getInt("nr_dias_validade"));
				oferta.setIcone(result.getString("nm_categoria"));
				
				lstOfertas.add(oferta);
			}

			return lstOfertas;
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
