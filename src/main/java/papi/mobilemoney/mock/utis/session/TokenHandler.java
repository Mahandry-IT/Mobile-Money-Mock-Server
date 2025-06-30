package papi.mobilemoney.mock.utis.session;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Base64;

public class TokenHandler {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder().withoutPadding();

    /**
     * Generate a token based on the given byte length
     * @param byteLength The number of random bytes to generate (eg: 32 for a ~43-character token)
     * @return A random string, Base64-encoded, suitable for use in URLs
     */
    public static String generateToken(int byteLength) {
        if (byteLength <= 0) {
            throw new RuntimeException("The token length must be > 0");
        }
        byte[] randomBytes = new byte[byteLength];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }


    public static String[] getTokenFromHeader(String authHeader, String regex) {
        String[] parts = authHeader.split(regex, 2);
        if (parts.length != 2) {
            throw new RuntimeException("The requested service needs credentials.");
        }
        return parts;
    }

    public static LocalDateTime addSecondNow(int seconds) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        return LocalDateTime.of(today, now).plusSeconds(seconds);
    }



}
