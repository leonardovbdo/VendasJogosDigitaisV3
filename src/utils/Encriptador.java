package utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encriptador {

    private static final String ALGORITMO_DE_ENCRIPTACAO = "AES";

    public static String encriptar(String dados, SecretKeySpec chave) throws Exception {
        Cipher cifrador = Cipher.getInstance(ALGORITMO_DE_ENCRIPTACAO);
        cifrador.init(Cipher.ENCRYPT_MODE, chave);

        byte[] cifragem = cifrador.doFinal(dados.getBytes());
        return Base64.getEncoder().encodeToString(cifragem);
    }

    public static String decrypt(String encryptedData, SecretKeySpec chave) throws Exception{
        Cipher cifrador = Cipher.getInstance(ALGORITMO_DE_ENCRIPTACAO);
        cifrador.init(Cipher.DECRYPT_MODE, chave);

        byte[] bytes = Base64.getDecoder().decode(encryptedData);
        byte[] bytesDecifrados = cifrador.doFinal(bytes);
        return new String(bytesDecifrados);
    }

}
