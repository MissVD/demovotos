package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.UI.Alerta;

public class EncuestasDAO {
    //mostrar todos registros de encuestas
    public static List<Encuestas> mostrar_encuestas() {
        String consulta = "SELECT * FROM encuestas";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            try (ResultSet rs = stmt.executeQuery()){
                List<Encuestas> encuestas = new ArrayList<>();
                while(rs.next()) {
                    Encuestas encuesta = new Encuestas(rs.getString("codigo_encuesta"), rs.getString("nombre"), rs.getString("descripcion"), rs.getBoolean("tiempo_real"), rs.getBoolean("anonimo"), rs.getTimestamp("fecha_inicio").toLocalDateTime(), rs.getTimestamp("fecha_fin").toLocalDateTime());
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
    public static List<Encuestas> mostrar_encuestas_parametro(int opcion, String parametro) {
        String [] columna = {"codigo_encuesta", "nombre", "descripcion", "tiempo_real", "anonimo", "fecha_inicio", "fecha_fin"};
        
        if (opcion < 0 || opcion >= columna.length){
            Alerta.mostrar("Opción de búsqueda no válida.");
            return new ArrayList<>();
        }
        
        String consulta = "SELECT * FROM encuestas WHERE " + columna[opcion] + " = ?";
        
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            
            switch (opcion) {
                case 0:
                case 1:
                case 2: stmt.setString(1, parametro);
                        break;
                case 3:
                case 4: stmt.setBoolean(1, Boolean.parseBoolean(parametro));
                        break;
                case 5: 
                case 6: stmt.setTimestamp(1, Timestamp.valueOf(parametro));
                        break;
                default:
                    Alerta.mostrar("Opción no válida.");
                    return new ArrayList<>();
            }

            try (ResultSet rs = stmt.executeQuery()){
                List<Encuestas> encuestas = new ArrayList<>();
                while(rs.next()) {
                    Encuestas encuesta = new Encuestas(rs.getString("codigo_encuesta"), rs.getString("nombre"), rs.getString("descripcion"), rs.getBoolean("tiempo_real"), rs.getBoolean("anonimo"), rs.getTimestamp("fecha_inicio").toLocalDateTime(), rs.getTimestamp("fecha_fin").toLocalDateTime());
                    encuestas.add(encuesta);
                }
            return encuestas;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error en la busqueda por parámetro de encuestas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    //insertar encuesta
    public static void insertar_encuesta(Encuestas encuesta) {
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
            System.out.println("Encuesta insertada correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la inserción de la encuesta: " + e.getMessage());
        }
    }

    //modificar encuesta
    public static void modificar_encuesta(Encuestas encuesta) {
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
    public static void eliminar_encuesta(Encuestas encuesta) {
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
