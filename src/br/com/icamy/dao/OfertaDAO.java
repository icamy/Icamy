package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Oferta;
import br.com.icamy.beans.Prestador;
import br.com.icamy.beans.Servico;
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

	public int insert(Oferta oferta) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "INSERT INTO t_icm_oferta ("
						+ "cd_servico, cd_prestador, tx_oferta, vl_oferta, nr_minutos_execucao, nr_dias_validade"
						+ ") values (?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, oferta.getServico().getCodigo());
			statement.setInt(2, oferta.getPrestador().getCodigo());
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
	
	public Oferta selectWhereOferta(int codigo) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			String sql = "SELECT * FROM  t_icm_oferta "
						+ "NATURAL JOIN t_icm_servico "
						+ "NATURAL JOIN t_icm_categoria_servico "
						+ "NATURAL JOIN t_icm_prestador "
						+ "WHERE cd_oferta = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, codigo);
			result = statement.executeQuery();
			
			if (result.next()) {
				Oferta oferta = new Oferta();
				oferta.setCodigo(result.getInt("cd_oferta"));
				oferta.setDescricao(result.getString("tx_oferta"));
				oferta.setValor(result.getDouble("vl_oferta"));
				oferta.setExecucaoEmMinutos(result.getInt("nr_minutos_execucao"));
				oferta.setValidadeEmDias(result.getInt("nr_dias_validade"));

				oferta.setServico(new Servico());
				oferta.getServico().setCodigo(result.getInt("cd_servico"));
				oferta.getServico().setCategoriaServico(new CategoriaServico());
				oferta.getServico().getCategoriaServico().setCodigo(result.getInt("cd_categoria"));
				oferta.getServico().getCategoriaServico().setNome(result.getString("nm_categoria"));
				oferta.getServico().setNome(result.getString("nm_servico"));
				oferta.getServico().setStatus(result.getString("st_servico").charAt(0));

				oferta.setPrestador(new Prestador());
				oferta.getPrestador().setCodigo(result.getInt("cd_prestador"));
				oferta.getPrestador().setNome(result.getString("nm_prestador"));
				oferta.getPrestador().setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
				oferta.getPrestador().setDocumento(result.getLong("nr_documento"));
				oferta.getPrestador().setTelefone(result.getLong("nr_telefone"));
				oferta.getPrestador().setEmail(result.getString("ds_email"));
				oferta.getPrestador().setApresentacao(result.getString("tx_apresentacao"));
				oferta.getPrestador().setNascimento(result.getString("dt_nascimento"));
				oferta.getPrestador().setUrlFoto(result.getString("ds_url_foto"));

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

	public List<Oferta> selectAll() throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "SELECT * FROM  t_icm_oferta "
					+ "NATURAL JOIN t_icm_servico "
					+ "NATURAL JOIN t_icm_categoria_servico "
					+ "NATURAL JOIN t_icm_prestador ";
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

				oferta.setServico(new Servico());
				oferta.getServico().setCodigo(result.getInt("cd_servico"));
				oferta.getServico().setCategoriaServico(new CategoriaServico());
				oferta.getServico().getCategoriaServico().setCodigo(result.getInt("cd_categoria"));
				oferta.getServico().getCategoriaServico().setNome(result.getString("nm_categoria"));
				oferta.getServico().setNome(result.getString("nm_servico"));
				oferta.getServico().setStatus(result.getString("st_servico").charAt(0));

				oferta.setPrestador(new Prestador());
				oferta.getPrestador().setCodigo(result.getInt("cd_prestador"));
				oferta.getPrestador().setNome(result.getString("nm_prestador"));
				oferta.getPrestador().setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
				oferta.getPrestador().setDocumento(result.getLong("nr_documento"));
				oferta.getPrestador().setTelefone(result.getLong("nr_telefone"));
				oferta.getPrestador().setEmail(result.getString("ds_email"));
				oferta.getPrestador().setApresentacao(result.getString("tx_apresentacao"));
				oferta.getPrestador().setNascimento(result.getString("dt_nascimento"));
				oferta.getPrestador().setUrlFoto(result.getString("ds_url_foto"));

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
	
	public List<Oferta> selectWherePrestador(Prestador p) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "SELECT * FROM  t_icm_oferta "
						+ "NATURAL JOIN t_icm_servico "
						+ "NATURAL JOIN t_icm_categoria_servico "
						+ "NATURAL JOIN t_icm_prestador "
						+ "WHERE cd_prestador = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, p.getCodigo());
			result = statement.executeQuery();
			List<Oferta> lstOfertas = new ArrayList<Oferta>();

			while (result.next()) {
				Oferta oferta = new Oferta();
				oferta.setCodigo(result.getInt("cd_oferta"));
				oferta.setDescricao(result.getString("tx_oferta"));
				oferta.setValor(result.getDouble("vl_oferta"));
				oferta.setExecucaoEmMinutos(result.getInt("nr_minutos_execucao"));
				oferta.setValidadeEmDias(result.getInt("nr_dias_validade"));

				oferta.setServico(new Servico());
				oferta.getServico().setCodigo(result.getInt("cd_servico"));
				oferta.getServico().setCategoriaServico(new CategoriaServico());
				oferta.getServico().getCategoriaServico().setCodigo(result.getInt("cd_categoria"));
				oferta.getServico().getCategoriaServico().setNome(result.getString("nm_categoria"));
				oferta.getServico().setNome(result.getString("nm_servico"));
				oferta.getServico().setStatus(result.getString("st_servico").charAt(0));

				oferta.setPrestador(p);
//				oferta.getPrestador().setCodigo(result.getInt("cd_prestador"));
//				oferta.getPrestador().setNome(result.getString("nm_prestador"));
//				oferta.getPrestador().setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
//				oferta.getPrestador().setDocumento(result.getLong("nr_documento"));
//				oferta.getPrestador().setTelefone(result.getLong("nr_telefone"));
//				oferta.getPrestador().setEmail(result.getString("ds_email"));
//				oferta.getPrestador().setApresentacao(result.getString("tx_apresentacao"));
//				oferta.getPrestador().setNascimento(result.getString("dt_nascimento"));
//				oferta.getPrestador().setUrlFoto(result.getString("ds_url_foto"));

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
