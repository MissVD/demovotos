package com.example.seguridad;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CifradoAES {

    private static final String ALGORITMO = "AES";

    public static String cifrar(String texto, String clave) throws Exception {
        SecretKeySpec key = crearClave(clave);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] textoCifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    public static String descifrar(String textoCifrado, String clave) throws Exception {
        SecretKeySpec key = crearClave(clave);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] textoDescifrado = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(textoDescifrado, StandardCharsets.UTF_8);
    }

    private static SecretKeySpec crearClave(String clave) {
        byte[] claveBytes = new byte[16];
        byte[] parametroClaveBytes = clave.getBytes(StandardCharsets.UTF_8);

        System.arraycopy(parametroClaveBytes, 0, claveBytes, 0, Math.min(parametroClaveBytes.length, claveBytes.length));

        return new SecretKeySpec(claveBytes, ALGORITMO);
    }
}
