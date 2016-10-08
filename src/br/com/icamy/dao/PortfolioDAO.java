package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Bairro;
import br.com.icamy.beans.Portfolio;
import br.com.icamy.beans.Prestador;
import br.com.icamy.factory.ConnectionFactory;

public class PortfolioDAO {
	private Connection connection;

	public PortfolioDAO() throws Exception {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new Exception(e);
		}
	}
	
	public List<Portfolio> selectWherePrestador(Prestador p) throws Exception {
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Portfolio> lstPortfolio = new ArrayList<Portfolio>();
		String sql = "SELECT * FROM t_icm_portfolio "
					+ "WHERE cd_prestador=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, p.getCodigo());
			result = statement.executeQuery();
			while (result.next()) {
				Portfolio portfolio = new Portfolio();
				portfolio.setCodigo(result.getInt("cd_arquivo"));
				portfolio.setUrl(result.getString("ds_url_arquivo"));
				portfolio.setNome(result.getString("nm_arquivo"));
				lstPortfolio.add(portfolio);
			}
			return lstPortfolio;
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
