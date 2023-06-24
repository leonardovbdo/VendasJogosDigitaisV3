package utils;

import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;

public class GeradorChaves {

    /*
     * Método responsável por gerar uma chave a partir dos bytes extraídos do áudio.
     * O método recebe como parâmetro um array de bytes 'bytes' contendo os bytes extraídos.
     * O método cria um novo array de bytes chamado 'chavesEncriptadas' com um tamanho fixo de 16,
     * que corresponde à quantidade de bytes necessária para gerar uma chave AES de 128 bits.
     * Em seguida, um loop é iniciado para percorrer os elementos do array 'bytes' ou um máximo de 16 elementos,
     * o que for menor. Dentro do loop, cada elemento 'key' é obtido do array e o primeiro byte desse elemento
     * é armazenado no array 'chavesEncriptadas' criado pelo método.
     * Por fim, um objeto da classe 'SecretKeySpec' é criado para gerar a chave a partir do array de bytes 'chavesEncriptadas'
     * usando o algoritmo AES.
     * A chave gerada é retornada como um objeto do tipo 'SecretKeySpec'.
     * Caso o array de bytes 'bytes' seja nulo ou vazio, o método retorna null.
     */

    public SecretKeySpec gerarChaves(byte[] bytes) {
        if (bytes != null && bytes.length > 0) {
            byte[] chavesEncriptadas = new byte[16];
            for (int i = 0; i < Math.min(bytes.length, 16); i++) {
                byte key = bytes[i];
                chavesEncriptadas[i] = key;
            }
            return new SecretKeySpec(chavesEncriptadas, "AES");
        }

        return null;
    }

}
