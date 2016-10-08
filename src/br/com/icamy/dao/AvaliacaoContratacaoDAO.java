package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.AvaliacaoContratacao;
import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.factory.ConnectionFactory;

public class AvaliacaoContratacaoDAO {
	private Connection conexao;
	
	public AvaliacaoContratacaoDAO() throws Exception {
		try {
			this.conexao = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public List<AvaliacaoContratacao> select(int cdContratacao) throws Exception {
		List<AvaliacaoContratacao> lstAvaliacoes = new ArrayList<AvaliacaoContratacao>();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM t_icm_avaliacao_contratacao";
			statement = conexao.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next()) {
				AvaliacaoContratacao aval = new AvaliacaoContratacao();
				aval.setCodigo(result.getInt("cd_avaliacao"));
				aval.setData(result.getString("dt_avaliacao"));
				aval.setNota(result.getInt("vl_nota"));
				aval.setComentario(result.getString("tx_comentario"));
				lstAvaliacoes.add(aval);
			}
			return lstAvaliacoes;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			if (conexao != null)
				try {
					result.close();
					statement.close();
					conexao.close();
				} catch (RuntimeException e) {
					e.printStackTrace();
					throw new Exception(e);
				}
		}
	}

}
