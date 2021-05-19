package com.bradleykenny.personms.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;

@Service
public class EncryptionService {

    @Value("${encryption.key}")
    private String encryptionKey;

    /**
     * Takes an input string and returns it in an encrypted form.
     * @param message
     * @return
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     */
    public String encrypt (String message) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] encKeyInBytes = this.encryptionKey.getBytes();
        SecretKeySpec key = new SecretKeySpec(encKeyInBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        return base64Encode((cipher.doFinal(message.getBytes())));
    }

    public String decrypt (String input) throws GeneralSecurityException {
        byte[] encKeyInBytes = this.encryptionKey.getBytes();
        SecretKeySpec key = new SecretKeySpec(encKeyInBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] cryptoText = cipher.doFinal(base64Decode(input));

        return new String(cryptoText);
    }

    private static String base64Encode (byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
    private static byte[] base64Decode (String msg) {
        return Base64.getDecoder().decode(msg);
    }
}









