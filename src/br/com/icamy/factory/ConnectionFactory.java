package br.com.icamy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection()
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName ("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://icamydb.mysql.uhserver.com";
        String url = "jdbc:mysql://localhost:3306/icamydb";
//        Connection conexao = DriverManager.getConnection (url,"icamydbuser","icamy@2016");
        Connection conexao = DriverManager.getConnection (url,"root","fiap");
        System.out.println ("Yeah!!! Database connection established");
        return conexao;
    }
}