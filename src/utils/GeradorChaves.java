package utils;

import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;

public class GeradorChaves {

    /*
    * Método que terá como função receber a lista de bytes extraídos do áudio.
    * O método irá prosseguir criando um array de bytes novo com tamanho fixo de 16
    * que será a quantidade de bytes utilizada para gerar uma chave AES de 128 bits.
    * Após isso, um loop é iniciado para percorrer os elementos da lista de bytes do
    * parâmetro ou um máximo de 16 elementos, o que for menor. Dentro do loop, cada
    * elemento 'key' é obtido da lista e o primeiro byte desse elemento é armazenado
    * no array criado pelo método. Por fim, um objeto da classe 'SecretKeySpec' será
    * responsavel por gerar as chaves do array com o uso do algoritmo de 'AES'.
    */

    public SecretKeySpec gerarChaves(ArrayList<byte[]> bytes) {
        if (bytes != null && bytes.size() > 0) {
            byte[] chavesEncriptadas = new byte[16];
            for (int i = 0; i < Math.min(bytes.size(), 16); i++) {
                byte[] key = bytes.get(i);
                chavesEncriptadas[i] = key[0];
            }
            return new SecretKeySpec(chavesEncriptadas, "AES");
        }

        return null;
    }

}
