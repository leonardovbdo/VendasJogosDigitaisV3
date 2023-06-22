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

    private final ArrayList<byte[]> audioBytesList = new ArrayList<>();

    /*
    * Método que terá como função extrair bytes do arquivo de audio encontrado através do
    * parâmetro que irá receber o caminho absoluto do arquivo. Assim que o método encontra
    * o arquivo de áudio ele irá percorrer cada byte individualmente utilizando um loop
    * 'for-each'. Para cada byte, ele verifica se o número de bytes capturados já atingiu
    * ou excedeu um limite máximo definido 'MAX_BYTES_NUMBERS'. Dentro do loop, o byte atual
    * é armazenado em um novo array de bytes 'numberBytes', contendo apenas um único byte.
    * Esse array é adicionado a uma lista chamada 'audioBytesList' que será lista dos bytes
    * que serão usados posteriormente na aplicação.
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


    public byte[] getAudioBytes(int i) {
        System.out.println(Arrays.toString(audioBytesList.get(i)));
        return audioBytesList.get(i);
    }
}