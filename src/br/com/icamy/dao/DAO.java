package br.com.icamy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.icamy.factory.ConnectionFactory;

abstract public class DAO {
    private Connection connection;

    public DAO() throws Exception {
        connection = new ConnectionFactory().getConnection();
    }

    public ResultSet retrieve(String sql) throws Exception {
        try {
            return connection.prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            throw new Exception("Ocorreu um erro durante a execução da consulta: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro: " + e.getMessage());
        } finally {
            connection.close();
        }
    }
        
    public int executeAndGetKey(String sql) throws Exception {
        try {
            return connection.createStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            throw new Exception("Ocorreu um erro durante a execução da consulta: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro: " + e.getMessage());
        } finally {
            connection.close();
        }
    }
    
    public int execute(String sql) throws Exception {
        try {
            return connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new Exception("Ocorreu um erro durante a execução da consulta: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro: " + e.getMessage());
        } finally {
            connection.close();
        }
    }    
}
