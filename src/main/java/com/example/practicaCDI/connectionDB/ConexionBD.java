package com.example.practicaCDI.connectionDB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3306/test?";
    private static String username = "root";
    private static String password = "admin";

    public static Connection getConnection() throws SQLException, NamingException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Context initContext = null;
        initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");
        return ds.getConnection();
    }
}