package utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encriptador {

    private static final String ALGORITMO_DE_ENCRIPTACAO = "AES";

    /*
     * Método que tem como funhção receber uma String de dados a serem criptografados
     * e uma chave do tipo 'SecretKeySpec' que é gerada a partir da classe 'GeradorChaves'.
     * Um objeto 'Cipher' com o algoritmo de encriptação 'AES' é criado e assim que a variável
     * 'dados' é convertida em um array de bytes será realizada a criptografia usando o método
     * 'doFinal' do 'Cipher' que retornará os bytes criptografados.
     * Os bytes criptografados são então convertidos em uma estrutura de String codificada em
     * Base64 e essa estrutura será armazenada na variável 'encriptacao'. Por fim, a variável
     * é retornada.
     */

    public static String encriptar(String dados, SecretKeySpec chave) throws Exception {

        String encriptacao = null;

        Cipher cifrador = Cipher.getInstance(ALGORITMO_DE_ENCRIPTACAO);
        cifrador.init(Cipher.ENCRYPT_MODE, chave);
        byte[] cifragem = cifrador.doFinal(dados.getBytes());

        encriptacao = Base64.getEncoder().encodeToString(cifragem);
        return encriptacao;
    }

    /*
    * O método que tem como função receber uma String de dados criptografados e a
    * chave gerada pela classe 'GeradorChaves' e assim descriptografar esses dados,
    * retornando em uma String.
    * Primeiramente o objeto 'Cipher é criado e ele está com o algoritmo 'AES' e
    * a variável 'dadosCriptografados' é decodificada da Base64 para obter um array de bytes
    * correspondente aos dados criptografados.
    * Os bytes decodificados são então passados para o método 'doFinal' do 'Cipher',
    * que realiza a descriptografia e retorna os bytes originais.
    * Esses bytes são convertidos em uma nova estrutura String para uma variável dados,
    * que em seguida é retornada pelo método.
    */

    public static String decrypt(String dadosCriptografados, SecretKeySpec chave) throws Exception{

        String dados = null;

        Cipher cifrador = Cipher.getInstance(ALGORITMO_DE_ENCRIPTACAO);
        cifrador.init(Cipher.DECRYPT_MODE, chave);
        byte[] bytes = Base64.getDecoder().decode(dadosCriptografados);
        byte[] bytesDecifrados = cifrador.doFinal(bytes);

        dados = new String(bytesDecifrados);
        return dados;
    }

}
