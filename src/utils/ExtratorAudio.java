package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ExtratorAudio {
    private static final int MAX_BYTES_NUMBERS = 20;

    private ArrayList<byte[]> audioBytesList = new ArrayList<>();

    public void extractBytes(String inputFile) {
        try {
            byte[] fileBytes = Files.readAllBytes(Path.of(inputFile));
            int bytesNumbersCaptured = 0;

            for (byte fileByte : fileBytes) {
                if (bytesNumbersCaptured >= MAX_BYTES_NUMBERS) {
                    break;
                }

                byte[] numberBytes = {fileByte};
                audioBytesList.add(numberBytes);
                bytesNumbersCaptured++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<byte[]> getAudioBytes() {
        return audioBytesList;
    }
}