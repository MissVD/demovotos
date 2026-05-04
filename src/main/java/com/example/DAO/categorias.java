package com.example.DAO;

public class categorias {
    private int id_categoria;
    private String nombre;
    private String codigo_encuesta;

    public categorias() {
        this.id_categoria = 0;
        this.nombre = "";
        this.codigo_encuesta = "";
    }

    public categorias(int id_categoria, String nombre, String codigo_encuesta) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.codigo_encuesta = codigo_encuesta;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_encuesta() {
        return codigo_encuesta;
    }

    public void setCodigo_encuesta(String codigo_encuesta) {
        this.codigo_encuesta = codigo_encuesta;
    }
}
