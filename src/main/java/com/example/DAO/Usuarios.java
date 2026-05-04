package com.example.DAO;

public class Usuarios {
    private String DNI;
    private String admin;
    private String usuario;
    private String password_hash;

    public Usuarios() {
        this.DNI = "";
        this.admin = "";
        this.usuario = "";
        this.password_hash = "";
    }
    
    public Usuarios(String DNI, String admin, String usuario, String password_hash) {
        this.DNI = DNI;
        this.admin = admin;
        this.usuario = usuario;
        this.password_hash = password_hash;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

}
