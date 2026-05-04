package com.example.DAO;
import java.time.LocalDateTime;

public class encuestas {
    private String codigo_encuesta;
    private String nombre;
    private String descripcion;
    private boolean tiempo_real;
    private boolean anonimo;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;

    public encuestas() {
        this.codigo_encuesta = "";
        this.nombre = "";
        this.descripcion = "";
        this.tiempo_real = false;
        this.anonimo = false;
        this.fecha_inicio = LocalDateTime.now();
        this.fecha_fin = LocalDateTime.now();
    }

    public encuestas (String codigo_encuesta, String nombre, String descripcion, boolean tiempo_real, boolean anonimo, LocalDateTime fecha_inicio, LocalDateTime fecha_fin) {
        this.codigo_encuesta = codigo_encuesta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo_real = tiempo_real;
        this.anonimo = anonimo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public String getCodigo_encuesta() {
        return codigo_encuesta;
    }

    public void setCodigo_encuesta(String codigo_encuesta) {
        this.codigo_encuesta = codigo_encuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTiempo_real() {
        return tiempo_real;
    }

    public void setTiempo_real(boolean tiempo_real) {
        this.tiempo_real = tiempo_real;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

}
