package com.example.DAO;

public class RelacionUsuarioTipo {
    private String DNI;
    private int id_tipo;

    public RelacionUsuarioTipo() {
        this.DNI = "";
        this.id_tipo = 0;
    }
    
    public RelacionUsuarioTipo(String DNI, int id_tipo) {
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
