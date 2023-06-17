package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AudioDataExtractor {
    private static final int MAX_BYTES_NUMBERS = 20;

    private ArrayList<byte[]> audioBytesList = new ArrayList<>();

    public void extractAudioBytes(String inputFile) {
        try (FileInputStream inputStream = new FileInputStream(new File(inputFile))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int bytesNumbersCaptured = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1 && bytesNumbersCaptured < MAX_BYTES_NUMBERS) {
                for (int i = 0; i < bytesRead; i++) {
                    if (bytesNumbersCaptured >= MAX_BYTES_NUMBERS) {
                        break;
                    }

                    byte[] bytesNumber = {buffer[i]};
                    audioBytesList.add(bytesNumber);
                    bytesNumbersCaptured++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getBytesNumbers() {
        return MAX_BYTES_NUMBERS;
    }

    public ArrayList<byte[]> getAudioBytes() {
        return audioBytesList;
    }
}