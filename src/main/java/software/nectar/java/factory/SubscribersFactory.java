package software.nectar.java.factory;

import org.json.JSONObject;
import software.nectar.java.factory.base.BaseFactory;
import software.nectar.java.factory.base.exceptions.ApiResponseException;
import software.nectar.java.models.Subscriber;
import software.nectar.java.utils.Payload;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscribersFactory extends BaseFactory<Subscriber> {

    private final String SUBSCRIBERS_PATH = "/v1/subscribers";

    public SubscribersFactory(String key, String secret, String host) {
        super(key, secret, host);
    }

    public Subscriber getSubscriber(String ref)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        return extractFrom(get(SUBSCRIBERS_PATH, String.format("ref=%s", ref), JSON_CONTENT_TYPE));
    }

    public String createSubscriber(String name, String phoneNo,
                                boolean activated)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("phone_no", phoneNo);
        params.put("activated", activated);

        JSONObject resp = post(SUBSCRIBERS_PATH, new Payload(params), JSON_CONTENT_TYPE);
        if ((Integer) ((JSONObject) resp.get("status")).get("code") == 200)
            return (String) ((JSONObject) resp.get("data")).get("ref");
        else throw new ApiResponseException(String.format("Status Code %d %s",
                ((JSONObject) resp.get("status")).get("code"),
                ((JSONObject) resp.get("status")).get("message")));
    }

    public String updateSubscriber(String subscriberRef, String name,
                                   String phoneNo, boolean activated)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("phone_no", phoneNo);
        params.put("activated", activated);

        JSONObject resp = put(SUBSCRIBERS_PATH, String.format("subscriber_ref=%s", subscriberRef),
                new Payload(params), JSON_CONTENT_TYPE);
        if ((Integer) ((JSONObject) resp.get("status")).get("code") == 200)
            return (String) ((JSONObject) resp.get("data")).get("ref");
        else throw new ApiResponseException(String.format("Status Code %d %s",
                ((JSONObject) resp.get("status")).get("code"),
                ((JSONObject) resp.get("status")).get("message")));
    }

    public void activateSubscriber(String subscriberRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        put(String.format("%s/%s", SUBSCRIBERS_PATH, subscriberRef), "", null, JSON_CONTENT_TYPE);
    }

    public void deactivateSubscriber(String subscriberRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        delete(String.format("%s/%s", SUBSCRIBERS_PATH, subscriberRef), "", JSON_CONTENT_TYPE);
    }

    @Override
    public Subscriber extractFrom(JSONObject responseObj)
        throws ApiResponseException {
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONObject subscribers = responseObj.getJSONObject("data").getJSONObject("data");
            return new Subscriber(((String) subscribers.get("name")),
                    (String) subscribers.get("phone_no"),
                    (String) subscribers.get("ref"),
                    (Boolean) subscribers.get("activated"),
                    Instant.parse((String) subscribers.get("created_at")),
                    Instant.parse((String) subscribers.get("updated_at")));
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }

    @Override
    public List<Subscriber> extractMultipleFrom(JSONObject responseObj)
            throws ApiResponseException {
        throw null;
    }
}
