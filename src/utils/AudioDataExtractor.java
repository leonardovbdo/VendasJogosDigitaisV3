package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AudioDataExtractor {
    private static final int MAX_BYTES_NUMBERS = 10;

    private List<byte[]> audioBytesList = new ArrayList<>();

    public void extractAudioBytes(String inputFile) {
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

    public int getBytesNumbers() {
        return MAX_BYTES_NUMBERS;
    }

    public List<byte[]> getAudioBytes() {
        return audioBytesList;
    }
}