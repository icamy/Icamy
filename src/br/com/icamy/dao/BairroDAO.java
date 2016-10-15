package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Bairro;
import br.com.icamy.beans.Prestador;
import br.com.icamy.factory.ConnectionFactory;

public class BairroDAO {
	private Connection connection;

	public BairroDAO() throws Exception {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	public List<Bairro> selectWherePrestador(Prestador p) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Bairro> lstBairros = new ArrayList<Bairro>();
		String sql = "SELECT cd_bairro, nm_bairro, ds_regiao "
					+ "FROM t_icm_prestador_bairro "
					+ "NATURAL JOIN t_icm_bairro "
					+ "WHERE cd_prestador=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, p.getCodigo());
			result = statement.executeQuery();
			while (result.next()) {
				Bairro bairro = new Bairro();
				bairro.setCodigo(result.getInt("cd_bairro"));
				bairro.setNome(result.getString("nm_bairro"));
				bairro.setRegiao(result.getString("ds_regiao"));
				lstBairros.add(bairro);
			}
			return lstBairros;
		} catch (SQLException e) {
			throw new Exception (e);
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
