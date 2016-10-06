package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Prestador;
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
	
//	public int insert(Prestador prestador) throws Exception {
//		
//	}
	
	public Prestador get(int codigo) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			String sql = "SELECT * FROM  t_icm_prestador "
						+ "WHERE cd_prestador = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, codigo);
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

				return p;
			} else {
				throw new RegistroNaoEncontradoException("Registro n�o encontrado");
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
	
	public List<Prestador> getPrestadoresDeServicosDe(int cdCategoria) throws Exception {
		List<Prestador> prestadores = new ArrayList<Prestador>();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "";
		
		try {
			sql += "select t_icm_prestador.* from t_icm_categoria ";
			sql += "natural join t_icm_servico "; 
			sql += "natural join t_icm_oferta";
    		sql += "natural join t_icm_prestador";
    		sql += "where cd_categoria = ?;";
    		
    		statement = connection.prepareStatement(sql);
    		statement.setInt(1, cdCategoria);
    		
    		result = statement.executeQuery();
    		
    		while (result.next()) {
    			prestadores.add(new Prestador(result.getInt("cd_prestador"), result.getString("nm_prestador"),
    					result.getLong("nr_telefone"), result.getString("ds_email"), "", result.getString("dt_nascimento"),
    					result.getString("ds_tipo_pessoa").charAt(0), result.getLong("nr_documento"), result.getString("tx_apresentacao")));
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
