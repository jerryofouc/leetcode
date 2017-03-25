package jerryofouc.github.io;


/**
 * Created by xiaojiez on 3/25/17.
 */
public class EncodeandDecodeTinyURL {
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return new String(java.util.Base64.getEncoder().encode(longUrl.getBytes()));
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return new String(java.util.Base64.getDecoder().decode(shortUrl.getBytes()));
    }
}
