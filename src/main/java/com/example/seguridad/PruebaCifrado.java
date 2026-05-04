package com.example.seguridad;

public class PruebaCifrado {
    public static void main(String[] args) {
        try {
            String password = "vdvh1998";
            String clave = "MiClaveSecreta123";

            String cifrada = CifradoAES.cifrar(password, clave);
            System.out.println("Password cifrada: " + cifrada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
