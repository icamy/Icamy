package br.com.icamy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection()
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName ("com.mysql.jdbc.Driver");
        /*
         * Alternar url, usuï¿½rio e senha conforme ambiente (desenvolvimento ou produï¿½ï¿½o:
         * 
         * AMBIENTE DE DESENVOLVIMENTO:
         * URL: String url = "jdbc:mysql://localhost:3306/icamydb";
         * CONEXAO: (LUCAS - USANDO MAMP C/SENHA): Connection conexao = DriverManager.getConnection (url,"root","root");
         * CONEXAO: (DEMAIS - USANDO WAMP/XAMPP S/ SENHA): Connection conexao = DriverManager.getConnection (url,"root","");
         * 
         * AMBIENTE DE PRODUÇÃO:
         * URL: String url = "jdbc:mysql://icamydb.mysql.uhserver.com/icamybd";
         * CONEXAO: Connection conexao = DriverManager.getConnection (url,"icamydbuser","icamy@2016");
         */
        String url = "jdbc:mysql://icamydb.mysql.uhserver.com/icamydb";
        Connection conexao = DriverManager.getConnection (url,"icamydbuser","icamy@2016");
        return conexao;
    }
}