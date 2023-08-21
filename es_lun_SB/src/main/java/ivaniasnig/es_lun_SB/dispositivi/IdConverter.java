package ivaniasnig.es_lun_SB.dispositivi;

import java.security.Key;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class IdConverter implements AttributeConverter<UUID, String> {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String secret = "mysup3rs3cr3tttt";

    @Override
    public String convertToDatabaseColumn(UUID attribute) {
        try {
            Key key = new SecretKeySpec(secret.getBytes(), "AES");
            Cipher c = Cipher.getInstance(ALGORITHM);

            c.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(c.doFinal(attribute.toString().getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UUID convertToEntityAttribute(String dbData) {
        try {
            Key key = new SecretKeySpec(secret.getBytes(), "AES");
            Cipher c = Cipher.getInstance(ALGORITHM);

            c.init(Cipher.DECRYPT_MODE, key);
            return UUID.fromString(new String(c.doFinal(Base64.getDecoder().decode(dbData))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



