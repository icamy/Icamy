package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Prestador;
import br.com.icamy.bo.BairroBO;
import br.com.icamy.bo.CategoriaServicoBO;
import br.com.icamy.bo.OfertaBO;
import br.com.icamy.bo.PortfolioBO;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;
import br.com.icamy.factory.ConnectionFactory;

public class PrestadorDAO {
	private Connection connection;

	public PrestadorDAO() throws Exception {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	public List<Prestador> selectAll() throws Exception {
		List<Prestador> lstPrestadores = new ArrayList<Prestador>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT * FROM t_icm_prestador";
		
		try {
    		statement = connection.prepareStatement(sql);
    		result = statement.executeQuery();
    		
    		while (result.next()) {
    			Prestador p = new Prestador();
    			p.setCodigo(result.getInt("cd_prestador"));
				p.setNome(result.getString("nm_prestador"));
				p.setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
				p.setDocumento(result.getLong("nr_documento"));
				p.setTelefone(result.getLong("nr_telefone"));
				p.setEmail(result.getString("ds_email"));
				p.setSenha(result.getString("ds_senha"));
				p.setApresentacao(result.getString("tx_apresentacao"));
				p.setNascimento(result.getString("dt_nascimento"));
				p.setUrlFoto(result.getString("ds_url_foto"));
				p.setBairro(new BairroBO().getByPrestador(p));
				p.setPortfolio(new PortfolioBO().getByPrestador(p));
				p.setCategoria(new CategoriaServicoBO().getByPrestador(p));
    			lstPrestadores.add(p);
    		}
    		
    		return lstPrestadores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
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
	
	public Prestador selectWherePrestador(int cdPrestador) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			String sql = "SELECT * FROM  t_icm_prestador "
						+ "WHERE cd_prestador = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cdPrestador);
			result = statement.executeQuery();
			
			if (result.next()) {
				Prestador p = new Prestador();
    			p.setCodigo(result.getInt("cd_prestador"));
				p.setNome(result.getString("nm_prestador"));
				p.setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
				p.setDocumento(result.getLong("nr_documento"));
				p.setTelefone(result.getLong("nr_telefone"));
				p.setEmail(result.getString("ds_email"));
				p.setSenha(result.getString("ds_senha"));
				p.setApresentacao(result.getString("tx_apresentacao"));
				p.setNascimento(result.getString("dt_nascimento"));
				p.setUrlFoto(result.getString("ds_url_foto"));
				p.setBairro(new BairroBO().getByPrestador(p));
				p.setPortfolio(new PortfolioBO().getByPrestador(p));
				p.setCategoria(new CategoriaServicoBO().getByPrestador(p));

				return p;
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
	
	public List<Prestador> selectWhereCategoria(int cdCategoria) throws Exception {
		List<Prestador> lstPrestadores = new ArrayList<Prestador>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT DISTINCT cd_prestador, nm_prestador, tx_apresentacao, ds_url_foto "
					+ "FROM t_icm_prestador "
					+ "INNER JOIN t_icm_oferta USING (cd_prestador) "
					+ "INNER JOIN t_icm_servico USING (cd_servico) "
					+ "INNER JOIN t_icm_categoria_servico USING (cd_categoria) "
					+ "WHERE cd_categoria=?";
		
		try {
    		statement = connection.prepareStatement(sql);
    		statement.setInt(1, cdCategoria);
    		
    		result = statement.executeQuery();
    		
    		while (result.next()) {
    			Prestador p = new Prestador();
    			p.setCodigo(result.getInt("cd_prestador"));
				p.setNome(result.getString("nm_prestador"));
				//p.setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
				//p.setDocumento(result.getLong("nr_documento"));
				//p.setTelefone(result.getLong("nr_telefone"));
				//p.setEmail(result.getString("ds_email"));
				//p.setSenha(result.getString("ds_senha"));
				p.setApresentacao(result.getString("tx_apresentacao"));
				//p.setNascimento(result.getString("dt_nascimento"));
				p.setUrlFoto(result.getString("ds_url_foto"));
				p.setBairro(new BairroBO().getByPrestador(p));
				p.setPortfolio(new PortfolioBO().getByPrestador(p));
				p.setCategoria(new CategoriaServicoBO().getByPrestador(p));
				
    			lstPrestadores.add(p);
    		}
    		return lstPrestadores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
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
	
	public List<Prestador> selectWhereServico(int cdServico) throws Exception {
		List<Prestador> prestadores = new ArrayList<Prestador>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT DISTINCT cd_prestador, nm_prestador, tx_apresentacao, ds_url_foto "
					+ "FROM t_icm_prestador "
					+ "INNER JOIN t_icm_oferta USING (cd_prestador) "
					+ "INNER JOIN t_icm_servico USING (cd_servico) "
					+ "INNER JOIN t_icm_categoria_servico USING (cd_categoria) "
					+ "WHERE cd_servico=?";
		
		try {
    		statement = connection.prepareStatement(sql);
    		statement.setInt(1, cdServico);
    		
    		result = statement.executeQuery();
    		
    		while (result.next()) {
    			Prestador p = new Prestador();
    			p.setCodigo(result.getInt("cd_prestador"));
				p.setNome(result.getString("nm_prestador"));
//				p.setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
//				p.setDocumento(result.getLong("nr_documento"));
//				p.setTelefone(result.getLong("nr_telefone"));
//				p.setEmail(result.getString("ds_email"));
//				p.setSenha(result.getString("ds_senha"));
				p.setApresentacao(result.getString("tx_apresentacao"));
//				p.setNascimento(result.getString("dt_nascimento"));
				p.setUrlFoto(result.getString("ds_url_foto"));
				p.setBairro(new BairroBO().getByPrestador(p));
				//p.setPortfolio(new PortfolioDAO().selectWherePrestador(p));
    			prestadores.add(p);
    		}
    		return prestadores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
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
	
	public List<Prestador> selectWhereBairro(String nmBairro) throws Exception {
		List<Prestador> prestadores = new ArrayList<Prestador>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT DISTINCT "
				+ "cd_prestador, nm_prestador, tx_apresentacao, ds_url_foto "
//				+ "cd_bairro, nm_bairro, "
//				+ "cd_servico, nm_servico,"
//				+ "cd_oferta, tx_oferta "
				+ "FROM t_icm_prestador "
				+ "INNER JOIN t_icm_prestador_bairro USING (cd_prestador) "
				+ "INNER JOIN t_icm_bairro USING (cd_bairro) "
				+ "INNER JOIN t_icm_oferta USING (cd_prestador) "
				+ "INNER JOIN t_icm_servico USING (cd_servico) "
				+ "WHERE nm_bairro = ?";
		
		try {
    		statement = connection.prepareStatement(sql);
    		statement.setString(1, nmBairro);
    		
    		result = statement.executeQuery();
    		
    		while (result.next()) {
    			Prestador p = new Prestador();
    			p.setCodigo(result.getInt("cd_prestador"));
				p.setNome(result.getString("nm_prestador"));
//				p.setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
//				p.setDocumento(result.getLong("nr_documento"));
//				p.setTelefone(result.getLong("nr_telefone"));
//				p.setEmail(result.getString("ds_email"));
//				p.setSenha(result.getString("ds_senha"));
				p.setApresentacao(result.getString("tx_apresentacao"));
//				p.setNascimento(result.getString("dt_nascimento"));
				p.setUrlFoto(result.getString("ds_url_foto"));
				p.setBairro(new BairroBO().getByPrestador(p));
				//p.setPortfolio(new PortfolioDAO().selectWherePrestador(p));
    			prestadores.add(p);
    		}
    		return prestadores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
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
	
	public List<Prestador> selectWhereServicoBairro(int cdServico, String nmBairro) throws Exception {
		List<Prestador> prestadores = new ArrayList<Prestador>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "SELECT DISTINCT "
					+ "cd_prestador, nm_prestador, tx_apresentacao, ds_url_foto "
//					+ "cd_bairro, nm_bairro, "
//					+ "cd_servico, nm_servico,"
//					+ "cd_oferta, tx_oferta "
					+ "FROM t_icm_prestador "
					+ "INNER JOIN t_icm_prestador_bairro USING (cd_prestador) "
					+ "INNER JOIN t_icm_bairro USING (cd_bairro) "
					+ "INNER JOIN t_icm_oferta USING (cd_prestador) "
					+ "INNER JOIN t_icm_servico USING (cd_servico) "
					+ "WHERE cd_servico = ? AND nm_bairro = ?";		
		try {
    		statement = connection.prepareStatement(sql);
    		statement.setInt(1, cdServico);
    		statement.setString(2, nmBairro);
    		
    		result = statement.executeQuery();
    		
    		while (result.next()) {
    			Prestador p = new Prestador();
    			p.setCodigo(result.getInt("cd_prestador"));
				p.setNome(result.getString("nm_prestador"));
//				p.setTipoPessoa(result.getString("ds_tipo_pessoa").charAt(0));
//				p.setDocumento(result.getLong("nr_documento"));
//				p.setTelefone(result.getLong("nr_telefone"));
//				p.setEmail(result.getString("ds_email"));
//				p.setSenha(result.getString("ds_senha"));
				p.setApresentacao(result.getString("tx_apresentacao"));
//				p.setNascimento(result.getString("dt_nascimento"));
				p.setUrlFoto(result.getString("ds_url_foto"));
				p.setBairro(new BairroBO().getByPrestador(p));
				//p.setPortfolio(new PortfolioDAO().selectWherePrestador(p));
    			prestadores.add(p);
    		}
    		return prestadores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
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
