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
import java.util.*;

public class UtilitiesFactory extends BaseFactory<Utility> {

    private final String UTILITIES_PATH = "/v1/utilities";

    public UtilitiesFactory(String key, String secret, String host) {
        super(key, secret, host);
    }

    public List<Utility> getUtilities()
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        return extractMultipleFrom(get(UTILITIES_PATH, "", JSON_CONTENT_TYPE));
    }

    public Utility getUtility(String utilityRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        return extractFrom(get(UTILITIES_PATH, String.format("utility_ref=%s", utilityRef), JSON_CONTENT_TYPE));
    }

    public List<Meter> getUtilityMeters(String utilityRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        return new MetersFactory(key, secret, host)
                .extractMultipleFrom(get(String.format("%s/%s/meters", UTILITIES_PATH, utilityRef),
                        null,  JSON_CONTENT_TYPE));
    }

    public String createUtility(String name, String contactPhoneNo,
                             double unitCharge, boolean activated,
                             String configRef, List<Meter> meters)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("contact_phone_no", contactPhoneNo);
        params.put("unit_charge", unitCharge);
        params.put("activated", activated);
        params.put("config_ref", configRef);
        params.put("meters", meters);

        JSONObject resp = post(UTILITIES_PATH, new Payload(params), JSON_CONTENT_TYPE);
        if ((Integer) ((JSONObject) resp.get("status")).get("code") == 200)
            return (String) ((JSONObject) resp.get("data")).get("ref");
        else throw new ApiResponseException(String.format("Status Code %d %s",
                ((JSONObject) resp.get("status")).get("code"),
                ((JSONObject) resp.get("status")).get("message")));
    }

    public String updateUtility(String utilityRef, String name, String contactPhoneNo,
                                double unitCharge, boolean activated,
                                String configRef, List<Meter> meters)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("contact_phone_no", contactPhoneNo);
        params.put("unit_charge", unitCharge);
        params.put("activated", activated);
        params.put("config_ref", configRef);
        params.put("meters", meters);

        JSONObject resp = put(UTILITIES_PATH, String.format("utility_ref=%s", utilityRef),
                new Payload(params), JSON_CONTENT_TYPE);
        if ((Integer) ((JSONObject) resp.get("status")).get("code") == 200)
            return (String) ((JSONObject) resp.get("data")).get("ref");
        else throw new ApiResponseException(String.format("Status Code %d %s",
                ((JSONObject) resp.get("status")).get("code"),
                ((JSONObject) resp.get("status")).get("message")));
    }

    public void activateUtility(String utilityRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
                IOException, ApiResponseException {
        put(String.format("%s/%s", UTILITIES_PATH, utilityRef),
                "", null, JSON_CONTENT_TYPE);
    }

    public void deactivateUtility(String utilityRef)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        delete(String.format("%s/%s", UTILITIES_PATH, utilityRef), "",
                JSON_CONTENT_TYPE);
    }

    public List<Utility> extractMultipleFrom(JSONObject responseObj)
            throws ApiResponseException {
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONArray utilities = responseObj.getJSONObject("data").getJSONArray("data");
            List<Utility> extractedUtilities = new ArrayList<>();
            utilities.forEach(utility -> {
                extractedUtilities.add(new Utility((String) ((JSONObject) utility).get("name"),
                        (String) ((JSONObject) utility).get("ref"),
                        (String) ((JSONObject) utility).get("contact_phone_no"),
                        ((BigDecimal)((JSONObject) utility).get("unit_charge")).doubleValue(),
                        (Boolean) ((JSONObject) utility).get("activated"),
                        (String) ((JSONObject) utility).get("config_ref"),
                        extractMeters((JSONObject) utility),
                        Instant.parse((String) ((JSONObject) utility).get("created_at")),
                        Instant.parse((String) ((JSONObject) utility).get("updated_at"))));
            });
            return extractedUtilities;

        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }

    public Utility extractFrom(JSONObject responseObj)
        throws ApiResponseException{
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONObject utility = responseObj.getJSONObject("data").getJSONObject("data");
            return new Utility(((String) utility.get("name")),
                    (String) utility.get("ref"),
                    (String) utility.get("contact_phone_no"),
                    ((BigDecimal) utility.get("unit_charge")).doubleValue(),
                    (Boolean) utility.get("activated"),
                    (String) utility.get("config_ref"),
                    extractMeters(utility),
                    Instant.parse((String) utility.get("created_at")),
                    Instant.parse((String) utility.get("updated_at")));
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }
}
