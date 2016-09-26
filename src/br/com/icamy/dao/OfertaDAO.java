package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Categoria;
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
			String sql = "inserto into t_icm_oferta (cd_servico, cd_prestador, ds_titulo, vl_oferta, ds_prazo, tx_oferta)"
					+ "values (?,?,?,?,?,?);";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, oferta.getServico().getCodigo());
			statement.setInt(2, oferta.getPrestador().getCodigo());
			statement.setString(3, oferta.getTitulo());
			statement.setDouble(4, oferta.getValor());
			statement.setString(5, oferta.getPrazo());
			statement.setString(6, oferta.getTexto());

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
	
	public Oferta get(int codigo) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			String sql = "select * from  t_icm_oferta natural join t_icm_servico natural join t_icm_categoria natural join t_icm_prestador where cd_oferta = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, codigo);
			result = statement.executeQuery();
			
			if (result.next()) {
				Oferta oferta = new Oferta();
				oferta.setCodigo(result.getInt("cd_oferta"));
				oferta.setTitulo(result.getString("ds_titulo"));
				oferta.setValor(result.getDouble("vl_oferta"));
				oferta.setPrazo(result.getString("ds_prazo"));
				oferta.setTexto(result.getString("tx_oferta"));

				oferta.setServico(new Servico());
				oferta.getServico().setCodigo(result.getInt("cd_servico"));
				oferta.getServico().setCategoria(new Categoria());
				oferta.getServico().getCategoria().setCodigo(result.getInt("cd_categoria"));
				oferta.getServico().getCategoria().setNome(result.getString("nm_categoria"));
				oferta.getServico().setNome(result.getString("nm_servico"));
				oferta.getServico().setStatus(result.getBoolean("st_servico"));
				oferta.getServico().setDescricao(result.getString("ds_servico"));

				oferta.setPrestador(new Prestador());
				oferta.getPrestador().setCodigo(result.getInt("cd_prestador"));
				oferta.getPrestador().setNome(result.getString("nm_prestador"));
				oferta.getPrestador().setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
				oferta.getPrestador().setDocumento(result.getLong("nr_documento"));
				oferta.getPrestador().setTelefone(result.getLong("nr_telefone"));
				oferta.getPrestador().setEmail(result.getString("ds_email"));
				oferta.getPrestador().setApresentacao(result.getString("tx_apresentacao"));
				oferta.getPrestador().setDataDeNascimento(result.getString("dt_nascimento"));

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

	public List<Oferta> getAll() throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			String sql = "select * from  t_icm_oferta natural join t_icm_servico natural join t_icm_categoria natural join t_icm_prestador;";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			List<Oferta> ofertas = new ArrayList<>();

			while (result.next()) {
				Oferta oferta = new Oferta();
				oferta.setCodigo(result.getInt("cd_oferta"));
				oferta.setTitulo(result.getString("ds_titulo"));
				oferta.setValor(result.getDouble("vl_oferta"));
				oferta.setPrazo(result.getString("ds_prazo"));
				oferta.setTexto(result.getString("tx_oferta"));

				oferta.setServico(new Servico());
				oferta.getServico().setCodigo(result.getInt("cd_servico"));
				oferta.getServico().setCategoria(new Categoria());
				oferta.getServico().getCategoria().setCodigo(result.getInt("cd_categoria"));
				oferta.getServico().getCategoria().setNome(result.getString("nm_categoria"));
				oferta.getServico().setNome(result.getString("nm_servico"));
				oferta.getServico().setStatus(result.getBoolean("st_servico"));
				oferta.getServico().setDescricao(result.getString("ds_servico"));

				oferta.setPrestador(new Prestador());
				oferta.getPrestador().setCodigo(result.getInt("cd_prestador"));
				oferta.getPrestador().setNome(result.getString("nm_prestador"));
				oferta.getPrestador().setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
				oferta.getPrestador().setDocumento(result.getLong("nr_documento"));
				oferta.getPrestador().setTelefone(result.getLong("nr_telefone"));
				oferta.getPrestador().setEmail(result.getString("ds_email"));
				oferta.getPrestador().setApresentacao(result.getString("tx_apresentacao"));
				oferta.getPrestador().setDataDeNascimento(result.getString("dt_nascimento"));

				ofertas.add(oferta);
			}

			return ofertas;
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
