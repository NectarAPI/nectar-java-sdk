package software.nectar.java.factory;

import org.json.JSONArray;
import org.json.JSONObject;
import software.nectar.java.factory.base.BaseFactory;
import software.nectar.java.factory.base.exceptions.ApiResponseException;
import software.nectar.java.models.Token;
import software.nectar.java.utils.DateTime;
import software.nectar.java.utils.Payload;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokensFactory extends BaseFactory<Token> {

    private final String TOKEN_PATH = "/v1/tokens";

    public TokensFactory(String key, String secret, String host) {
        super(key, secret, host);
    }

    public Token getToken(String ref)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        String path = String.format("ref=%s", ref);
        return extractFrom(get(TOKEN_PATH, path, JSON_CONTENT_TYPE));
    }

    public Token generateNativeElectricityToken(Instant tokenId, double amount,
                                                int randomNo, boolean isStid,
                                                String drn, String configRef,
                                                boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "0");
        params.put("subclass", "0");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("amount", amount);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftElectricityToken(double amount,
                                                     boolean isStid,
                                                     String drn, String configRef,
                                                     boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "0");
        params.put("subclass", "0");
        params.put("type", "prism-thrift");
        params.put("amount", amount);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeWaterToken(Instant tokenId, double amount,
                                          int randomNo, boolean isStid,
                                          String drn, String configRef,
                                          boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "0");
        params.put("subclass", "1");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("amount", amount);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftWaterToken(double amount, boolean isStid,
                                               String drn, String configRef,
                                               boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "0");
        params.put("subclass", "1");
        params.put("type", "prism-thrift");
        params.put("amount", amount);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeGasToken(Instant tokenId, double amount,
                                        int randomNo, boolean isStid,
                                        String drn, String configRef, boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "0");
        params.put("subclass", "2");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("amount", amount);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftGasToken(double amount, boolean isStid,
                                             String drn, String configRef,
                                             boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "0");
        params.put("subclass", "2");
        params.put("type", "prism-thrift");
        params.put("amount", amount);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeInitiateMeterTestDisplay10Token(Instant tokenId, String control,
                                                               int manufacturerCode, boolean isStid,
                                                               String drn, String configRef,
                                                               boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "1");
        params.put("subclass", "0");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("control", control);
        params.put("manufacturer_code", manufacturerCode);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftInitiateMeterTestDisplay10Token(int control,
                                                                    int manufacturerCode, boolean isStid,
                                                                    String drn, String configRef,
                                                                    boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "1");
        params.put("subclass", "0");
        params.put("type", "prism-thrift");
        params.put("control", control);
        params.put("manufacturer_code", manufacturerCode);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeInitiateMeterTestDisplay11Token(Instant tokenId, String control,
                                                               int manufacturerCode, boolean isStid,
                                                               String drn, String configRef,
                                                               boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "1");
        params.put("subclass", "1");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("control", control);
        params.put("manufacturer_code", manufacturerCode);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftInitiateMeterTestDisplay11Token(int control,
                                                                    int manufacturerCode, boolean isStid,
                                                                    String drn, String configRef,
                                                                    boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "1");
        params.put("subclass", "1");
        params.put("type", "prism-thrift");
        params.put("control", control);
        params.put("manufacturer_code", manufacturerCode);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeSetMaximumPowerLimitToken(Instant tokenId, int maximumPowerLimit,
                                                         int randomNo, boolean isStid,
                                                         String drn, String configRef,
                                                         boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "0");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("maximum_power_limit", maximumPowerLimit);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftSetMaximumPowerLimitToken(int maximumPowerLimit,
                                                              int flagTokenType, int flagTokenValue,
                                                              boolean isStid,
                                                              String drn, String configRef,
                                                              boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "0");
        params.put("type", "prism-thrift");
        params.put("maximum_power_limit", maximumPowerLimit);
        params.put("flag_token_type", flagTokenType);
        params.put("flag_token_value", flagTokenValue);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeClearCreditToken(Instant tokenId, int register,
                                                int randomNo, boolean isStid,
                                                String drn, String configRef,
                                                boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "1");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("register", register);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftClearCreditToken(boolean isStid,
                                                     String drn, String configRef,
                                                     boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "1");
        params.put("type", "prism-thrift");
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeSetTariffRateToken(Instant tokenId, int tariffRate,
                                                  int randomNo, boolean isStid,
                                                  String drn, String configRef,
                                                  boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "2");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("tariff_rate", tariffRate);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftSetTariffRateToken(boolean isStid,
                                                       String drn, String configRef,
                                                       boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "2");
        params.put("type", "prism-thrift");
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public List<Token> generateNativeDecoderKeyTokens(Instant tokenId, String newVendingKey,
                                                String newSupplyGroupCode, String newTariffIndex,
                                                int newKeyRevisionNo, int newKeyType, int newKeyExpiryNo,
                                                String newDrn, String newIssuerIdentificationNo, int ro,
                                                boolean isStid, String drn, String configRef,
                                                boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "3");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("new_vending_key", newVendingKey);
        params.put("new_supply_group_code", newSupplyGroupCode);
        params.put("new_tariff_index", newTariffIndex);
        params.put("new_key_revision_no", newKeyRevisionNo);
        params.put("new_key_type", newKeyType);
        params.put("new_key_expiry_no", newKeyExpiryNo);
        params.put("new_decoder_reference_number", newDrn);
        params.put("new_issuer_identification_no", newIssuerIdentificationNo);
        params.put("ro", ro);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params);
    }


    public List<Token> generatePrismThriftDecoderKeyTokens(boolean allow3Kct,
                                                     String newSupplyGroupCode, String newTariffIndex,
                                                     int newKeyRevisionNo,
                                                     boolean isStid, String drn, String configRef,
                                                     boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "3");
        params.put("type", "prism-thrift");
        params.put("allow_3Kct", allow3Kct);
        params.put("new_supply_group_code", newSupplyGroupCode);
        params.put("new_tariff_index", newTariffIndex);
        params.put("new_key_revision_no", newKeyRevisionNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params);
    }


    public Token generateNativeClearTamperConditionToken(Instant tokenId, int pad,
                                                         int randomNo, boolean isStid,
                                                         String drn, String configRef,
                                                         boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "5");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("pad", pad);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftClearTamperConditionToken(boolean isStid,
                                                              String drn, String configRef,
                                                              boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "5");
        params.put("type", "prism-thrift");
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeSetMaximumPhasePowerUnbalanceLimitToken(Instant tokenId,
                                                                       int mppul, int randomNo,
                                                                       boolean isStid, String drn,
                                                                       String configRef, boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "6");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("mppul", mppul);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftSetMaximumPhasePowerUnbalanceLimitToken(boolean isStid, String drn,
                                                                            String configRef, boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "6");
        params.put("type", "prism-thrift");
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generateNativeSetWaterMeterFactorToken(Instant tokenId, int wmFactor,
                                                        int randomNo, boolean isStid,
                                                        String drn, String configRef,
                                                        boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "7");
        params.put("type", "native");
        params.put("token_id", DateTime.formatDate(tokenId));
        params.put("wm_factor", wmFactor);
        params.put("random_no", randomNo);
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public Token generatePrismThriftSetWaterMeterFactorToken(boolean isStid,
                                                             String drn, String configRef,
                                                             boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("class", "2");
        params.put("subclass", "7");
        params.put("type", "prism-thrift");
        params.put("is_stid", isStid);
        params.put("decoder_reference_number", drn);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return generateTokens(params).get(0);
    }

    public HashMap<String, Object> decodeToken(String decoderReferenceNumber, String configRef,
                                               String token, boolean debug)
            throws NoSuchAlgorithmException, InvalidKeyException,
                    IOException, ApiResponseException {
        Map<String, Object> params = new HashMap<>();
        params.put("decoder_reference_number", decoderReferenceNumber);
        params.put("config_ref", configRef);
        params.put("debug", debug);
        return extractDecoded(post(String.format("%s/%s", TOKEN_PATH, token),
                new Payload(params), JSON_CONTENT_TYPE));
    }

    public List<Token> extractMultipleFrom(JSONObject responseObj)
            throws ApiResponseException {
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONArray returnedTokens = responseObj.getJSONObject("data").getJSONArray("data");
            List<Token> tokens = new ArrayList<>();
            for(int i = 0; i < returnedTokens.length(); i++) {
                JSONObject token = (JSONObject) returnedTokens.get(i);
                tokens.add(new Token((String) token.get("ref"),
                        (String) token.get("token_no"),
                        (String) token.get("user_ref"),
                        (String) token.get("token_type"),
                        (String) token.get("meter_no"),
                        Instant.parse((String) token.get("created_at"))));
            }
            return tokens;
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }

    public HashMap<String, Object> extractDecoded(JSONObject responseObj)
            throws ApiResponseException {
        HashMap<String, Object> decodedTokenParams = new HashMap<>();
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONObject decodedToken = responseObj.getJSONObject("data").getJSONObject("data");
            decodedToken.keySet().forEach(keyStr -> {
                decodedTokenParams.put(keyStr, decodedToken.get(keyStr));
            });
            return decodedTokenParams;
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }

    public Token extractFrom(JSONObject responseObj)
            throws ApiResponseException {
        if (responseObj.getJSONObject("status").getInt("code") == 200) {
            JSONObject token = (JSONObject) responseObj.getJSONObject("data").getJSONObject("data");
            return new Token((String) token.get("ref"),
                    (String) token.get("token_no"),
                    (String) token.get("user_ref"),
                    (String) token.get("token_type"),
                    (String) token.get("meter_no"),
                    Instant.parse((String) token.get("created_at")));
        }
        throw new ApiResponseException(
                String.format("Error: %s",
                        responseObj.getJSONObject("status").getString("message")));
    }

//    private Token generateToken(Map<String, Object> params)
//            throws NoSuchAlgorithmException, InvalidKeyException,
//            IOException, ApiResponseException {
//        return extractFrom(post(TOKEN_PATH, new Payload(params), JSON_CONTENT_TYPE));
//    }

    private List<Token> generateTokens(Map<String, Object> params)
            throws NoSuchAlgorithmException, InvalidKeyException,
            IOException, ApiResponseException {
        return extractMultipleFrom(post(TOKEN_PATH, new Payload(params), JSON_CONTENT_TYPE));
    }
}
