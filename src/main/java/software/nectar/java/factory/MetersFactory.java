package software.nectar.java.factory;

import org.json.JSONArray;
import org.json.JSONObject;
import software.nectar.java.factory.base.BaseFactory;
import software.nectar.java.factory.base.exceptions.ApiResponseException;
import software.nectar.java.models.Meter;
import software.nectar.java.models.MeterType;
import software.nectar.java.models.Subscriber;
import software.nectar.java.models.Utility;
import software.nectar.java.utils.Payload;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetersFactory extends BaseFactory<Meter> {

    private final String METERS_PATH = "/v1/meters";

    public MetersFactory(String key, String secret, String host) {
        super(key, secret, host);
    }

    public Meter getMeter(String ref)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        return extractFrom(get(METERS_PATH, String.format("ref=%s", ref), JSON_CONTENT_TYPE));
    }

    public String createMeter(BigDecimal no, boolean activated, String meterTypeRef,
                             String utilityRef, String subscriberRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("no", no);
        params.put("activated", activated);
        params.put("meter_type", meterTypeRef);
        params.put("utility_ref", utilityRef);
        params.put("subscriber_ref", subscriberRef);

        JSONObject resp = post(METERS_PATH, new Payload(params), JSON_CONTENT_TYPE);
        if ((Integer) ((JSONObject) resp.get("status")).get("code") == 200)
            return (String) ((JSONObject) resp.get("data")).get("ref");
        else throw new ApiResponseException(String.format("Status Code %d %s",
                ((JSONObject) resp.get("status")).get("code"),
                ((JSONObject) resp.get("status")).get("message")));
    }

    public String updateMeter(String meterRef, BigDecimal no, boolean activated,
                              String meterTypeRef, String utilityRef, String subscriberRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("no", no);
        params.put("activated", activated);
        params.put("meter_type", meterTypeRef);
        params.put("utility_ref", utilityRef);
        params.put("subscriber_ref", subscriberRef);

        JSONObject resp = put(METERS_PATH, String.format("meter_ref=%s", meterRef),
                new Payload(params), JSON_CONTENT_TYPE);
        if ((Integer) ((JSONObject) resp.get("status")).get("code") == 200)
            return (String) ((JSONObject) resp.get("data")).get("ref");
        else throw new ApiResponseException(String.format("Status Code %d %s",
                ((JSONObject) resp.get("status")).get("code"),
                ((JSONObject) resp.get("status")).get("message")));
    }

    public void activateMeter(String meterRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        put(String.format("%s/%s", METERS_PATH, meterRef), "", null, JSON_CONTENT_TYPE);
    }

    public void deactivateMeter(String meterRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        delete(String.format("%s/%s", METERS_PATH, meterRef), "", JSON_CONTENT_TYPE);
    }

    public List<Meter> extractMultipleFrom(JSONObject responseObj)
            throws ApiResponseException {
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            return extractMeters(responseObj);
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }

    public Meter extractFrom(JSONObject responseObj)
        throws ApiResponseException{
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            return extractMeter(responseObj.getJSONObject("data").getJSONObject("data"));
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }
}
