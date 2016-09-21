package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.Servico;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;

public class ServicoDAO {
  private Connection connection;

  public ServicoDAO() {
    super();
  }

  public boolean insert(Servico servico) throws SQLException {
    String query = "insert into servico (nm_servico, ds_servico, st_servico) ";
    query += "('" + servico.getNome() + "', '" + servico.getDescricao() + "', '" + servico.getStatus() + "')";
    Statement statement = connection.createStatement();

    ResultSet result = statement.executeQuery(query);

    if (result != null)
      return true;

    return false;
  }

  public boolean update(Servico servico) throws SQLException {
    String query = "update servico set nm_servico = '" + servico.getNome() + "', ds_servico = '"
        + servico.getDescricao() + "', ";
    query += "st_servico = " + servico.getStatus() + " where cd_servico = " + servico.getCodigo() + ";";

    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(query);

    if (result != null)
      return true;

    return false;
  }

  public boolean delete(Servico servico) throws SQLException {
    String query = "delete from servico where cd_servico = " + servico.getCodigo() + ";";
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(query);

    if (result != null)
      return true;

    return false;
  }

  public Servico get(int codigo) throws SQLException, RegistroNaoEncontradoException {
     String sql = "select * from servico where cd_servico = " + codigo + ";";
     Statement statement = connection.createStatement();
     ResultSet result = statement.executeQuery(sql);
     
     if (result != null) {
       return new Servico(
           result.getInt("cd_servico"), 
           result.getString("nm_servico"), 
           result.getBoolean("st_servico"), 
           result.getString("ds_servico"));
     } else {
       throw new RegistroNaoEncontradoException("Serviço " + codigo + " não encontrado"); 
     }
  }
  
  public List<Servico> getAll() throws SQLException {
    String sql = "select * from servico;";
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(sql);
    List<Servico> servicos = new ArrayList<Servico>();
    
    while (result.next()) {
      servicos.add(new Servico(
          result.getInt("cd_servico"), 
          result.getString("nm_servico"), 
          result.getBoolean("st_servico"), 
          result.getString("ds_servico")));
    }
    
    return servicos;
  }
}
