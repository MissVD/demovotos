package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.UI.Alerta;

public class encuestasDAO {
    //mostrar todos registros de encuestas
    public static List<encuestas> mostrar_encuestas() {
        String consulta = "SELECT * FROM encuestas";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            try (ResultSet rs = stmt.executeQuery()){
                List<encuestas> encuestas = new ArrayList<>();
                while(rs.next()) {
                    encuestas encuesta = new encuestas(rs.getString("codigo_encuesta"), rs.getString("nombre"), rs.getString("descripcion"), rs.getBoolean("tiempo_real"), rs.getBoolean("anonimo"), rs.getTimestamp("fecha_inicio").toLocalDateTime(), rs.getTimestamp("fecha_fin").toLocalDateTime());
                    encuestas.add(encuesta);
                }
            return encuestas;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error al obtener las encuestas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // mostrar encuestas por usuario
    public static List<encuestas> mostrar_encuestas_parametro(String columna, String parametro) {
        String consulta = "SELECT * FROM encuestas WHERE " + columna + " = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            stmt.setString(1, parametro);
            try (ResultSet rs = stmt.executeQuery()){
                List<encuestas> encuestas = new ArrayList<>();
                while(rs.next()) {
                    encuestas encuesta = new encuestas(rs.getString("codigo_encuesta"), rs.getString("nombre"), rs.getString("descripcion"), rs.getBoolean("tiempo_real"), rs.getBoolean("anonimo"), rs.getTimestamp("fecha_inicio").toLocalDateTime(), rs.getTimestamp("fecha_fin").toLocalDateTime());
                    encuestas.add(encuesta);
                }
            return encuestas;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error en la busqueda por parámetro de participaciones: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    //insertar encuesta
    public static void insertar_encuesta(encuestas encuesta) {
        String consulta = "INSERT INTO encuestas (codigo_encuesta, nombre, descripcion, tiempo_real, anonimo, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, encuesta.getCodigo_encuesta());
            stmt.setString(2, encuesta.getNombre());
            stmt.setString(3, encuesta.getDescripcion());
            stmt.setBoolean(4, encuesta.isTiempo_real());
            stmt.setBoolean(5, encuesta.isAnonimo());
            stmt.setTimestamp(6, Timestamp.valueOf(encuesta.getFecha_inicio()));
            stmt.setTimestamp(7, Timestamp.valueOf(encuesta.getFecha_fin()));
            stmt.executeUpdate();
            System.out.println("Participacion insertada correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la inserción de la participacion: " + e.getMessage());
        }
    }

    //modificar encuesta
    public static void modificar_encuesta(encuestas encuesta) {
        String consulta = "UPDATE encuestas SET nombre = ?, descripcion = ?, tiempo_real = ?, anonimo = ?, fecha_inicio = ?, fecha_fin = ? WHERE codigo_encuesta = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, encuesta.getNombre());
            stmt.setString(2, encuesta.getDescripcion());
            stmt.setBoolean(3, encuesta.isTiempo_real());
            stmt.setBoolean(4, encuesta.isAnonimo());
            stmt.setTimestamp(5, Timestamp.valueOf(encuesta.getFecha_inicio()));
            stmt.setTimestamp(6, Timestamp.valueOf(encuesta.getFecha_fin()));
            stmt.setString(7, encuesta.getCodigo_encuesta());
            stmt.executeUpdate();
            System.out.println("Encuesta modificada correctamente.");
        } catch (SQLException e) {
           Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la actualización de la encuesta: " + e.getMessage());
        }
    }

    //eliminar encuesta
    public static void eliminar_encuesta(encuestas encuesta) {
        String consulta = "DELETE FROM encuestas WHERE codigo_encuesta = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, encuesta.getCodigo_encuesta());
            stmt.executeUpdate();
            System.out.println("Encuesta borrada correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en el borrado de la encuesta: " + e.getMessage());           
        }
    }
}
