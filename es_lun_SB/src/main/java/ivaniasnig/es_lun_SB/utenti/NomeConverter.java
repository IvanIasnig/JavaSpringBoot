package ivaniasnig.es_lun_SB.utenti;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Base64;

@Converter
public class NomeConverter implements AttributeConverter<String, String> {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String secret = "mys3cretKey4Nome";  //chiave di 16 caratteri

    @Override
    public String convertToDatabaseColumn(String nome) {
        try {
            Key key = new SecretKeySpec(secret.getBytes(), "AES");
            Cipher c = Cipher.getInstance(ALGORITHM);

            c.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(c.doFinal(nome.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String encryptedNome) {
        try {
            Key key = new SecretKeySpec(secret.getBytes(), "AES");
            Cipher c = Cipher.getInstance(ALGORITHM);

            c.init(Cipher.DECRYPT_MODE, key);
            return new String(c.doFinal(Base64.getDecoder().decode(encryptedNome)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

