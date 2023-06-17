package utils;

import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;

public class GeradorChaves {

    public SecretKeySpec generateKeys(ArrayList<byte[]> bytes) {
        if (bytes != null) {
            byte[] chavesEncriptadas = new byte[16];
            for (int i = 0; i < bytes.size(); i++) {
                byte[] key = bytes.get(i);
                chavesEncriptadas[i] = key[0];
            }

            return new SecretKeySpec(chavesEncriptadas, "AES");
        }

        return null;
    }

    

}
