package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.UI.Alerta;

public class ParticipacionDAO {
    //mostrar todos registros de participacion
    public static List<Participacion> mostrar_participacion() {
        String consulta = "SELECT * FROM participacion";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            try (ResultSet rs = stmt.executeQuery()){
                List<Participacion> participaciones = new ArrayList<>();
                while(rs.next()) {
                    Participacion participacion = new Participacion(rs.getString("codigo_participacion"), rs.getInt("id_categoria"), rs.getInt("id_tipo"), rs.getTimestamp("fecha_voto").toLocalDateTime());
                    participaciones.add(participacion);
                }
            return participaciones;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error al obtener las participaciones: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // mostrar participacion por parametro
    public static List<Participacion> mostrar_participacion(int opcion, String parametro) {
        String[] columnas = {"codigo_participacion", "id_categoria", "id_tipo", "fecha_voto"};

        if (opcion < 0 || opcion >= columnas.length) {
            Alerta.mostrar("Opción de búsqueda no válida.");
            return new ArrayList<>();
        }

        String consulta = "SELECT * FROM participacion WHERE " + columnas[opcion] + " = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);) {
            switch (opcion) {
                case 0:
                    stmt.setString(1, parametro);
                    break;
                case 1:
                case 2:
                    stmt.setInt(1, Integer.parseInt(parametro));
                    break;
                case 3:
                    stmt.setTimestamp(1, Timestamp.valueOf(parametro));
                    break;
                default:
                    Alerta.mostrar("Opción no válida.");
                    return new ArrayList<>();
            }

            try (ResultSet rs = stmt.executeQuery()){
                List<Participacion> participaciones = new ArrayList<>();
                while(rs.next()) {
                    Participacion participacion = new Participacion(rs.getString("codigo_participacion"), rs.getInt("id_categoria"), rs.getInt("id_tipo"), rs.getTimestamp("fecha_voto").toLocalDateTime());
                    participaciones.add(participacion);
                }
            return participaciones;
            }
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            Alerta.mostrar("Error en la busqueda por parámetro de participaciones: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    //insertar participacion
    public static void insertar_participacion(Participacion participacion) {
        String consulta = "INSERT INTO participacion (codigo_participacion, id_categoria, id_tipo, fecha_voto) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, participacion.getCodigo_participacion());
            stmt.setInt(2, participacion.getId_categoria());
            stmt.setInt(3, participacion.getId_tipo());
            stmt.setTimestamp(4, Timestamp.valueOf(participacion.getFecha_voto()));
            stmt.executeUpdate();
            System.out.println("Participacion insertada correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la inserción de la participacion: " + e.getMessage());
        }
    }

    //modificar participacion
    public static void modificar_participacion(Participacion participacion) {
        String consulta = "UPDATE participacion SET id_categoria = ?, id_tipo = ?, fecha_voto = ? WHERE codigo_participacion = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setInt(1, participacion.getId_categoria());
            stmt.setInt(2, participacion.getId_tipo());
            stmt.setTimestamp(3, Timestamp.valueOf(participacion.getFecha_voto()));
            stmt.setString(4, participacion.getCodigo_participacion());
            stmt.executeUpdate();
            System.out.println("Participación modificada correctamente.");
        } catch (SQLException e) {
           Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en la actualización de la participación: " + e.getMessage());
        }
    }

    //eliminar participacion
    public static void eliminar_participacion(Participacion participacion) {
        String consulta = "DELETE FROM participacion WHERE codigo_participacion = ?";
        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(consulta);){
            stmt.setString(1, participacion.getCodigo_participacion());
            stmt.executeUpdate();
            System.out.println("Participacion borrada correctamente.");
        } catch (SQLException e) {
            Alerta.mostrar("Error en la conexión: " + e.getMessage());
        } catch (Exception e) {
            Alerta.mostrar("Error en el borrado de la participación: " + e.getMessage());           
        }
    }
}
