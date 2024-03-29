package software.nectar.java.factory;

import org.json.JSONArray;
import org.json.JSONObject;
import software.nectar.java.factory.base.BaseFactory;
import software.nectar.java.factory.base.exceptions.ApiResponseException;
import software.nectar.java.models.PublicKey;
import software.nectar.java.utils.Payload;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublicKeysFactory extends BaseFactory<PublicKey> {

    private final String PUBLIC_KEYS_PATH = "/v1/public_keys";

    public PublicKeysFactory(String key, String secret, String host) {
        super(key, secret, host);
    }

    public List<PublicKey> getPublicKeys(boolean activated)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        String path = String.format("activated=%b", activated);
        return extractMultipleFrom(gets(PUBLIC_KEYS_PATH, path, JSON_CONTENT_TYPE));
    }

    public PublicKey createPublicKey(String name, String key, boolean activated)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("key", key);
        params.put("activated", activated);
        return extractFrom(post(PUBLIC_KEYS_PATH, new Payload(params), JSON_CONTENT_TYPE));
    }

    public void activatePublicKey(String ref)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        put(PUBLIC_KEYS_PATH, String.format("ref=%s", ref), null, JSON_CONTENT_TYPE);
    }

    public void deactivatePublicKey(String ref)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        delete(PUBLIC_KEYS_PATH, String.format("ref=%s", ref), JSON_CONTENT_TYPE);
    }

    @Override
    public PublicKey extractFrom(JSONObject responseObj)
        throws ApiResponseException {
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONObject publicKey = responseObj.getJSONObject("data").getJSONObject("data");
            return new PublicKey((String) publicKey.get("key"),
                    (String) publicKey.get("user_ref"),
                    (Boolean) publicKey.get("activated"),
                    (String) publicKey.get("ref"),
                    Instant.parse((String) publicKey.get("created_at")));
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }

    @Override
    public List<PublicKey> extractMultipleFrom(JSONObject responseObj)
        throws ApiResponseException {
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONArray publicKeys = responseObj.getJSONObject("data").getJSONArray("data");
            List<PublicKey> extractedPublicKeys = new ArrayList<>();
            publicKeys.forEach(publicKey -> {
                extractedPublicKeys.add(new PublicKey((String) ((JSONObject) publicKey).get("key"),
                        (String) ((JSONObject) publicKey).get("user_ref"),
                        (Boolean) ((JSONObject) publicKey).get("activated"),
                        (String) ((JSONObject) publicKey).get("ref"),
                        Instant.parse((String) ((JSONObject) publicKey).get("created_at"))));
            });
            return extractedPublicKeys;
        }
        throw new ApiResponseException(responseObj.getJSONObject("status").getString("message"));
    }
}
