package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.UI.Alerta;

public class UsuariosDAO {

    // mostrar todos los usuarios
    public static List<Usuarios> mostrar_usuarios() {
        String consulta = "SELECT * FROM usuarios";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            try (ResultSet rs = stmt.executeQuery()){
                List<Usuarios> usuarios = new ArrayList<>();
                while(rs.next()) {
                    Usuarios usuario = new Usuarios(rs.getString("DNI"), rs.getString("admin"), rs.getString("usuario"), rs.getString("password_hash"));
                    usuarios.add(usuario);
                }
            return usuarios;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error en la busquedad de usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // mostrar usuarios por parametro
    public static List<Usuarios> mostrar_usuarios_por(int opcion, String parametro) {
        String[] columnas = {"DNI", "admin", "usuario"};

        if (opcion < 0 || opcion >= columnas.length) {
            Alerta.mostrar("Opción de búsqueda no válida.");
            return new ArrayList<>();
        }

        String consulta = "SELECT * FROM usuarios WHERE " + columnas[opcion] + " = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            stmt.setString(1, parametro);
            try (ResultSet rs = stmt.executeQuery()){
                List<Usuarios> usuarios = new ArrayList<>();
                while(rs.next()) {
                    Usuarios usuario = new Usuarios(rs.getString("DNI"), rs.getString("admin"), rs.getString("usuario"), rs.getString("password_hash"));
                    usuarios.add(usuario);
                }
            return usuarios;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error en la busqueda por parámetro de usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // insertar usuario
    public static void insertar_usuario(Usuarios usuario) {
        String consulta = "INSERT INTO usuarios (DNI, admin, usuario, password_hash) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, usuario.getDNI());
            stmt.setString(2, usuario.getAdmin());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getPassword_hash());
            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la inserción del usuario: " + e.getMessage());
        }
    }

    // modificar usuario
    public static void modificar_usuario(Usuarios usuario) {
        String consulta = "UPDATE usuarios SET usuario = ?, password_hash = ? WHERE DNI = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword_hash());
            stmt.setString(3, usuario.getDNI());
            stmt.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
           Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la actualización del usuario: " + e.getMessage());
        }
    }

    // eliminar usuario
    public static void eliminar_usuario(Usuarios usuario) {
        String consulta = "DELETE FROM usuarios where DNI = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, usuario.getDNI());
            stmt.executeUpdate();
            System.out.println("Usuario borrado correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en el borrado del usuario: " + e.getMessage());           
        }
    }
    
}
