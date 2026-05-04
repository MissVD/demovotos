package com.example.UI;

import java.util.List;
import com.example.DAO.Carrera;
import com.example.DAO.CarrerasDAO;
import com.example.DAO.Clasificacion;
import com.example.DAO.ClasificacionesDAO;
import com.example.DAO.Participante;
import com.example.DAO.ParticipantesDAO;
import javafx.scene.control.TextField;

//clase con métodos estáticos para validar
public class Validar {
    //comprueba si la carrera ya existe
    public static boolean carreraExiste(Carrera c){
        List<Carrera> carreras = CarrerasDAO.mostrarCarreras();
        for (Carrera carrera: carreras){
            if (c.equals(carrera)){
                return true;
            }
        }
        return false;
    }
    
    //comprueba si el/la participante ya existe
    public static boolean participanteExiste(Participante p){
        List<Participante> participantes = ParticipantesDAO.mostrarParticipantes();
        for (Participante participante: participantes){
            if (p.equals(participante)){
                return true;
            }
        }
        return false;
    }

    //comprueba si la clasificacion ya existe
    public static boolean clasificacionExiste(Clasificacion c){
        List<Clasificacion> clasificaciones = ClasificacionesDAO.mostrarClasificaciones();
        for (Clasificacion clasificacion: clasificaciones){
            if (c.equals(clasificacion)){
                return true;
            }
        }
        return false;
    }

    //comprueba si un participante ya ha calificado en esa carrera
    public static boolean mismoParticipanteCarrera(Clasificacion c){
        List<Clasificacion> clasificaciones = ClasificacionesDAO.mostrarClasificaciones();
        for (Clasificacion clasificacion: clasificaciones){
            if ((c.getIdCarrera()==clasificacion.getIdCarrera()) && (c.getIdParticipante()==clasificacion.getIdParticipante())){
                return true;
            }
        }
        return false;
    }

    //comprueba si se repite el puesto en esa carrera
    public static boolean puestoRepetido(Clasificacion c){
        List<Clasificacion> clasificaciones = ClasificacionesDAO.mostrarClasificaciones();
        for (Clasificacion clasificacion: clasificaciones){
            if ((c.getIdCarrera()==clasificacion.getIdCarrera()) && (c.getPuesto()==clasificacion.getPuesto())){
                return true;
            }
        }
        return false;
    }

    //comprueba si el texto es todo dígitos
    public static boolean esDigito(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //comprueba si el texto no tiene dígitos
    public static boolean contieneCaracteres(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //comprueba si la lista de carreras está vacía
    public static boolean listaCarreraVacia(List<Carrera> lista){
        return lista==null || lista.isEmpty();
    }

    //comprueba si la lista de participantes está vacía
    public static boolean listaParticipanteVacia(List<Participante> lista){
        return lista==null || lista.isEmpty();
    }

    //comprueba si la lista de clasificaciones está vacía
    public static boolean listaClasificacionesVacia(List<Clasificacion> lista){
        return lista==null || lista.isEmpty();
    }

    //comprueba si el textfield está vacío
    public static boolean campoVacio(TextField campo){
        return (campo==null || campo.getText().trim().isEmpty());
    }

    //comprueba si la edad es inválida o irrealista
    public static boolean edadInvalida(String texto) {
        return (Integer.parseInt(texto) < 1 || Integer.parseInt(texto) > 120);  
    }

    //comprueba si la distancia es inválida o irrealista
    public static boolean distanciaInvalida(String texto) {
        return (Integer.parseInt(texto) < 1 || Integer.parseInt(texto) > 300);
    }

    //comprueba si la longitud es inválida o irrealista
    public static boolean longitudInvalida(String texto) {
        return (texto.length()> 100);
    }

    //comprueba si el formato (HH:MM:SS) de tiempo es inválido
    public static boolean formatoTiempoInvalido(String texto) {
        return !texto.matches("\\d{2}:\\d{2}:\\d{2}");
    }

    //comprueba si el tiempo es inválido
    public static boolean tiempoInvalido(String texto) {
        return (Integer.parseInt(texto.substring(3,5)) > 59 || Integer.parseInt(texto.substring(6,8)) > 59);
    }
    
}
