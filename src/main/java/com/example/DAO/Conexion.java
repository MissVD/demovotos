package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//clase que gestiona la conexión a la base de datos
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_votaciones";
    private static final String USER = "vero";
    private static final String PASSWORD = "vdvh1998";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}