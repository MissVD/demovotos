package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.UI.Alerta;

public class TipoDeUsuarioDAO {

    //mostrar todos registros de tipo_de_usuario
    public static List<TipoDeUsuario> mostrar_tipo_de_usuarios() {
        String consulta = "SELECT * FROM tipo_de_usuario";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            try (ResultSet rs = stmt.executeQuery()){
                List<TipoDeUsuario> tipos = new ArrayList<>();
                while(rs.next()) {
                    TipoDeUsuario tipo = new TipoDeUsuario(rs.getInt("id_tipo"), rs.getString("nombre"));
                    tipos.add(tipo);
                }
            return tipos;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error al obtener el tipo de usuario: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    //insertar tipo_de_usuario
    public static void insertar_tipo_de_usuario(TipoDeUsuario tipo) {
        String consulta = "INSERT INTO tipo_de_usuario (id_tipo, nombre) VALUES (?, ?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setInt(1, tipo.getId_tipo());
            stmt.setString(2, tipo.getNombre());
            stmt.executeUpdate();
            System.out.println("Tipo de usuario insertado correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la inserción del tipo de usuario: " + e.getMessage());
        }
    }

    //modificar tipo_de_usuario
    public static void modificar_tipo_de_usuario(TipoDeUsuario tipo) {
        String consulta = "UPDATE tipo_de_usuario SET nombre = ? WHERE id_tipo = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, tipo.getNombre());
            stmt.setInt(2, tipo.getId_tipo());
            stmt.executeUpdate();
            System.out.println("Tipo de usuario modificado correctamente.");
        } catch (SQLException e) {
           Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la actualización del tipo de usuario: " + e.getMessage());
        }
    }

    //eliminar tipo_de_usuario
    public static void eliminar_tipo_de_usuario(TipoDeUsuario tipo) {
        String consulta = "DELETE FROM tipo_de_usuario where id_tipo = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setInt(1, tipo.getId_tipo());
            stmt.executeUpdate();
            System.out.println("Tipo de usuario borrado correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en el borrado del tipo de usuario: " + e.getMessage());           
        }
    }

}
