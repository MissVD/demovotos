package com.example.DAO;

public class relacion_usuario_tipo {
    private String DNI;
    private int id_tipo;

    public relacion_usuario_tipo() {
        this.DNI = "";
        this.id_tipo = 0;
    }
    
    public relacion_usuario_tipo(String DNI, int id_tipo) {
        this.DNI = DNI;
        this.id_tipo = id_tipo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

}