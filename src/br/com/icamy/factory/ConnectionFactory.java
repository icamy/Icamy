package br.com.icamy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection()
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName ("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://icamydb.mysql.uhserver.com";
        Conection conexao = DriverManager.getConnection (url,"icamydbuser","icamy@2016");
        System.out.println ("Database connection established");
        return conexao;
    }
}