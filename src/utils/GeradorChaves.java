package utils;

import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;

public class GeradorChaves {

    public SecretKeySpec generateKeys(ArrayList<byte[]> audioBytes) {
        if (audioBytes != null && audioBytes.size() > 0) {
            byte[] encryptionKeyBytes = new byte[16];
            for (int i = 0; i < Math.min(audioBytes.size(), 16); i++) {
                byte[] key = audioBytes.get(i);
                encryptionKeyBytes[i] = key[0];
            }

            SecretKeySpec secretKey = new SecretKeySpec(encryptionKeyBytes, "AES");

            return secretKey;
        }

        return null;
    }




}
