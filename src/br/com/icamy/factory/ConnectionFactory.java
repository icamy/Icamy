package br.com.icamy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection()
            throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/icamy", "tavaresl",
                "35624100@Lu");
        Class.forName("com.mysql.jdbc.Driver");
        return conexao;
    }
}