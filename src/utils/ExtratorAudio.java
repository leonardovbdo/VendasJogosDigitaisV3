package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtratorAudio {

    private static final int MAX_BYTES_NUMBERS = 20;

    /*
     * Declaração de uma variável de instância 'audioBytesList' do tipo ArrayList, que armazena arrays de bytes.
     * A lista 'audioBytesList' é usada para armazenar os arrays de bytes extraídos do arquivo de áudio.
     * Cada array de bytes contém um conjunto de bytes relacionados ao áudio.
     */
    private final ArrayList<byte[]> audioBytesList = new ArrayList<>();

    /*
     * Método que tem a função de extrair bytes de um arquivo de áudio com base no caminho absoluto fornecido.
     * Assim que o método localiza o arquivo de áudio, ele percorre cada byte individualmente usando um loop 'for-each'.
     * Para cada byte encontrado, é verificado se o número de bytes capturados já atingiu ou excedeu o limite máximo definido como 'MAX_BYTES_NUMBERS'.
     * Dentro do loop, o byte atual é armazenado em um novo array de bytes chamado 'numberBytes', que contém apenas um único byte.
     * Esse array é adicionado à lista 'audioBytesList', que será usada posteriormente na aplicação.
     * Além disso, o método utiliza um conjunto chamado 'uniqueBytes' para garantir que apenas bytes únicos sejam adicionados à lista.
     *
     * Caso o número máximo de bytes seja atingido, o loop é interrompido usando a instrução 'break'.
     * Além disso, se o byte atual já estiver presente no conjunto 'uniqueBytes', o loop avança para a próxima iteração usando a instrução 'continue'.
     */

    public void extractBytes(String inputFile) {
        try {
            byte[] fileBytes = Files.readAllBytes(Path.of(inputFile));
            int bytesNumbersCaptured = 0;
            Set<Byte> uniqueBytes = new HashSet<>();

            for (byte fileByte : fileBytes) {
                if (bytesNumbersCaptured >= MAX_BYTES_NUMBERS) {
                    break;
                }

                if (uniqueBytes.contains(fileByte)) {
                    continue;
                }

                byte[] numberBytes = {fileByte};
                audioBytesList.add(numberBytes);
                uniqueBytes.add(fileByte);
                bytesNumbersCaptured++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Método que retorna um array de bytes correspondente ao índice especificado da lista de bytes de áudio.
     * O método recebe um parâmetro 'i', que representa o índice desejado.
     * Ele recupera o array de bytes na posição 'i' da lista 'audioBytesList' e o retorna.
     */
    public byte[] getAudioBytes(int i) {
        return audioBytesList.get(i);
    }
}