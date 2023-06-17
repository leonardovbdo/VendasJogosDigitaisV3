package utils;

import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;

public class GeradorChaves {

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
