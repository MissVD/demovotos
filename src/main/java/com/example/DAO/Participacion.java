package com.example.DAO;

import java.time.LocalDateTime;

public class Participacion {
    private String codigo_participacion;
    private int id_categoria;
    private int id_tipo;
    private LocalDateTime fecha_voto;

    public Participacion() {
        this.codigo_participacion = "";
        this.id_categoria = 0;
        this.id_tipo = 0;
        this.fecha_voto = LocalDateTime.now();
    }

    public Participacion(String codigo_participacion, int id_categoria, int id_tipo, LocalDateTime fecha_voto) {
        this.codigo_participacion = codigo_participacion;
        this.id_categoria = id_categoria;
        this.id_tipo = id_tipo;
        this.fecha_voto = fecha_voto;
    }

    public String getCodigo_participacion() {
        return codigo_participacion;
    }

    public void setCodigo_participacion(String codigo_participacion) {
        this.codigo_participacion = codigo_participacion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public LocalDateTime getFecha_voto() {
        return fecha_voto;
    }

    public void setFecha_voto(LocalDateTime fecha_voto) {
        this.fecha_voto = fecha_voto;
    }

}
