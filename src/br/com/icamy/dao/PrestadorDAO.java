package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Oferta;
import br.com.icamy.beans.Prestador;
import br.com.icamy.beans.Servico;
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
}
