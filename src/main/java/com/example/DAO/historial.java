package com.example.DAO;

public class historial {
    private String DNI;
    private String codigo_participacion;

    public historial() {
        this.DNI = "";
        this.codigo_participacion = "";
    }

    public historial(String DNI, String codigo_participacion) {
        this.DNI = DNI;
        this.codigo_participacion = codigo_participacion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCodigo_participacion() {
        return codigo_participacion;
    }

    public void setCodigo_participacion(String codigo_participacion) {
        this.codigo_participacion = codigo_participacion;
    }

}
