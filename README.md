# Nectar Java SDK

Nectar Java SDK is a wrapper that allows generation of IEC 62055-41 STSEd2 compliant prepaid tokens using the Nectar API.

## Installation

Use the package manager [gradle](https://gradle.org) to install this package by adding the following line to your *build.gradle*.

```bash
implementation 'software.nectar.java:nectar-java-sdk:3.0.1-alpha'
```

## Example Usage

The API calls below use example parameters to show how the SDK is used. Please refer to the documentation for descriptions of the parameters that need to be applied to the API calls below.

```java
package software.nectar.java;

import software.nectar.java.models.*;

import java.time.Instant;
import java.util.List;

public class NectarTest {

    // Get from the Nectar API Portal at https://portal.nectar.software/credentials
    private final String KEY = "<key>";
    private final String SECRET = "<secret>";
    
    private final String HOST = "<host_ip>";

    private Nectar nectar = new Nectar(KEY, SECRET, HOST);

    public static void main(String[] args) {
        try {
            NectarTest test = new NectarTest();
            test.getToken();

            /**
             * Generate Native Tokens
             * Native tokens are tokens generated 
             * by Nectar API's virtual HSM.
             */
            test.generateNativeElectricityToken();
            test.generateNativeWaterToken();
            test.generateNativeGasToken();
            test.generateNativeInitiateMeterTestDisplay10Token();
            test.generateNativeInitiateMeterTestDisplay11Token();
            test.generateNativeSetMaximumPowerLimitToken();
            test.generateNativeClearCreditToken();
            test.generateNativeSetTariffRateToken();
            test.generateNativeDecoderKeyTokens();
            test.generateNativeClearTamperConditionToken();
            test.generateNativeSetMaximumPhasePowerUnbalanceLimitToken();
            test.generateNativeSetWaterMeterFactorToken();

            /**
             * Generate Prism Thrift Tokens
             * Prism Thrift tokens are tokens generated via 
             * an integration of Nectar API and a PRISM HSM 
             * via the Thrift API.
             */
            test.generatePrismThriftElectricityToken();
            test.generatePrismThriftWaterToken();
            test.generatePrismThriftGasToken();
            test.generatePrismThriftInitiateMeterTestDisplay10Token();
            test.generatePrismThriftInitiateMeterTestDisplay11Token();
            test.generatePrismThriftSetMaximumPowerLimitToken();
            test.generatePrismThriftClearCreditToken();
            test.generatePrismThriftSetTariffRateToken();
            test.generatePrismThriftDecoderKeyTokens();
            test.generatePrismThriftClearTamperConditionToken();
            test.generatePrismThriftSetMaximumPhasePowerUnbalanceLimitToken();
            test.generatePrismThriftSetWaterMeterFactorToken();
            test.decodeNativeToken();
            test.decodePrismThriftToken();

            test.getUser();
            test.createUser();
            test.updateUser();
            test.deleteUser();

            test.getPublicKeys();
            test.createPublicKey();
            test.activatePublicKey();
            test.deactivatePublicKey();

            test.getNotifications();
            test.setNotificationsReadStatus();

            test.getCredits();
            test.getTransactions();

            test.getCredentials();
            test.activateCredentials();
            test.deactivateCredentials();

            test.getUtilities();
            test.getUtility();
            test.getMetersForUtility();
            test.createUtility();
            test.updateUtility();
            test.activateUtility();
            test.deactivateUtility();

            test.getMeter();
            test.createMeter();
            test.updateMeter();
            test.activateMeter();
            test.deactivateMeter();

            test.getSubscriber();
            test.createSubscriber();
            test.updateSubscriber();
            test.activateSubscriber();
            test.deactivateSubscriber();

            test.getConfiguration();
            test.createConfiguration();
            test.activateConfiguration();
            test.deactivateConfiguration();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void getToken() throws Exception {
        Token generatedToken = nectar.getTokenFactory().getToken("466d464c-eba1-4157-baa8-e18465d4b566");
        System.out.print(generatedToken);
    }

    private void generateNativeElectricityToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeElectricityToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeWaterToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeWaterToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeGasToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeGasToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeInitiateMeterTestDisplay10Token() throws Exception {
        String control = "00";
        int manufacturerCode = 58;
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeInitiateMeterTestDisplay10Token(generationTime, control, manufacturerCode, isStid, drn,
                        nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeInitiateMeterTestDisplay11Token() throws Exception {
        String control = "268435455";
        int manufacturerCode = 1234;
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeInitiateMeterTestDisplay11Token(generationTime, control, manufacturerCode, isStid, drn,
                        nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeSetMaximumPowerLimitToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeSetMaximumPowerLimitToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeClearCreditToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeClearCreditToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeSetTariffRateToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeSetTariffRateToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeDecoderKeyTokens() throws Exception {
        String newVendingKey = "0abc123def456789";
        String newSupplyGroupCode = "123456";
        String newTariffIndex = "01";
        int newKeyRevisionNo = 1;
        int newKeyType = 1;
        int newKeyExpiryNo = 255;
        String newDrn = drn;
        String newIssuerIdentificationNo = "600727";
        int ro = 0;

        List<Token> generatedTokens = nectar.getTokenFactory()
                .generateNativeDecoderKeyTokens(generationTime,
                        newVendingKey, newSupplyGroupCode, newTariffIndex, newKeyRevisionNo,
                        newKeyType, newKeyExpiryNo, newDrn, newIssuerIdentificationNo, ro,
                        isStid, drn, nativeConfigRef, false);
        System.out.print(generatedTokens);
    }

    private void generateNativeClearTamperConditionToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeClearTamperConditionToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeSetMaximumPhasePowerUnbalanceLimitToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generateNativeSetMaximumPhasePowerUnbalanceLimitToken(generationTime, 5, 5, false,
                        drn, nativeConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generateNativeSetWaterMeterFactorToken() throws Exception {
        Token generatedToken = nectar.getTokenFactory()
                .generateNativeSetWaterMeterFactorToken(generationTime, wmFactor, randomNo,
                        isStid, drn, nativeConfigRef, false);
        System.out.println(generatedToken);
    }

    private void generatePrismThriftElectricityToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generatePrismThriftElectricityToken(10, isStid,
                        drn, prismThriftConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generatePrismThriftWaterToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generatePrismThriftWaterToken(10, isStid,
                        drn, prismThriftConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generatePrismThriftGasToken() throws Exception {
        Token generatedToken =  nectar.getTokenFactory()
                .generatePrismThriftGasToken(10, isStid,
                        drn, prismThriftConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generatePrismThriftInitiateMeterTestDisplay10Token() throws Exception {
        int control = 0;
        int manufacturerCode = 58;
        Token generatedToken =  nectar.getTokenFactory()
                .generatePrismThriftInitiateMeterTestDisplay10Token(control, manufacturerCode, isStid, drn,
                        prismThriftConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generatePrismThriftInitiateMeterTestDisplay11Token() throws Exception {
        int control = 0;
        int manufacturerCode = 5812;
        Token generatedToken = nectar.getTokenFactory()
                .generatePrismThriftInitiateMeterTestDisplay11Token(control, manufacturerCode, isStid, drn,
                        prismThriftConfigRef, false);
        System.out.print(generatedToken);
    }

    private void generatePrismThriftSetMaximumPowerLimitToken() throws Exception {
        int maximumPowerLimit = 1;
        int flagTokenType = 5;
        int flagTokenValue = 0;
        Token generatedToken = nectar.getTokenFactory()
                .generatePrismThriftSetMaximumPowerLimitToken(maximumPowerLimit,
                        flagTokenType, flagTokenValue, isStid, drn, prismThriftConfigRef, false);
        System.out.println(generatedToken);
    }

    private void generatePrismThriftClearCreditToken() throws Exception {
        Token generatedToken = nectar.getTokenFactory()
                .generatePrismThriftClearCreditToken(isStid, drn, prismThriftConfigRef, debug);
        System.out.println(generatedToken);
    }

    private void generatePrismThriftSetTariffRateToken() throws Exception {
        Token generatedToken = nectar.getTokenFactory()
                .generatePrismThriftSetTariffRateToken(isStid, drn, prismThriftConfigRef, debug);
        System.out.println(generatedToken);
    }

    private void generatePrismThriftDecoderKeyTokens() throws Exception {
        boolean allow3Kct = false;
        String newSupplyGroupCode = "123456";
        String newTariffIndex = "01";
        int newKeyRevisionNo = 1;

        List<Token> generatedTokens = nectar.getTokenFactory()
                .generatePrismThriftDecoderKeyTokens(allow3Kct, newSupplyGroupCode,
                        newTariffIndex, newKeyRevisionNo, isStid, drn, prismThriftConfigRef, false);
        System.out.println(generatedTokens);
    }

    private void generatePrismThriftClearTamperConditionToken() throws Exception {
        Token generatedToken = nectar.getTokenFactory()
                .generatePrismThriftClearTamperConditionToken(isStid, drn, prismThriftConfigRef, false);
        System.out.println(generatedToken);
    }

    private void generatePrismThriftSetMaximumPhasePowerUnbalanceLimitToken() throws Exception {
        Token generatedToken = nectar.getTokenFactory()
                .generatePrismThriftSetMaximumPhasePowerUnbalanceLimitToken(isStid,
                        drn, prismThriftConfigRef, false);
        System.out.println(generatedToken);
    }

    private void decodeNativeToken() throws Exception {
        String token = "61453851089841090384";
        HashMap<String, Object> decodedTokenParams
                = nectar.getTokenFactory().decodeToken(drn, nativeConfigRef, token, false);
        System.out.println(decodedTokenParams);
    }

    private void decodePrismThriftToken() throws Exception {
        String token = "55775868427448788093";
        HashMap<String, Object> decodedTokenParams
                = nectar.getTokenFactory().decodeToken(drn, prismThriftConfigRef, token, false);
        System.out.println(decodedTokenParams);
    }

    private void generatePrismThriftSetWaterMeterFactorToken() throws Exception {
        Token generatedToken = nectar.getTokenFactory()
                .generatePrismThriftSetWaterMeterFactorToken(isStid, drn, prismThriftConfigRef, false);
        System.out.println(generatedToken);
    }

    private void getUser() throws Exception {
        User user = nectar.getUsersFactory().getUser();
        System.out.println(String.format("Get User\n====================\n%s\n", user));
    }

    private void createUser() throws Exception {
        String firstName = "first_name";
        String lastName = "last_name";
        String username = "username";
        String password = "password";
        String phoneNo = "0700100100";
        String imageUrl = "https://image.url";
        String email = "user@email.com";

        String createdUserRef = nectar.getUsersFactory()
                .createUser(firstName, lastName, username, password,
                        phoneNo, imageUrl, email, true);
        System.out.println(String.format("Create User\n====================\nRef: %s\n", createdUserRef));
    }

    private void updateUser() throws Exception {
        String firstName = "first_name";
        String lastName = "last_name";
        String username = "username";
        String password = "password";
        String phoneNo = "0700100100";
        String imageUrl = "https://image.url";
        String email = "user@email.com";

        nectar.getUsersFactory().updateUser(firstName, lastName, username, password,
                phoneNo, imageUrl, email, true);
        System.out.println(String.format("Update User\n====================\n"));
    }

    private void deleteUser() throws Exception {
        nectar.getUsersFactory().deleteUser();
        System.out.println("Delete User\n====================\n");
    }

    private void getPublicKeys() throws Exception {
        final boolean activated = false;
        List<PublicKey> publicKeys = nectar.getPublicKeysFactory().getPublicKeys(activated);
        System.out.println(String.format("Get Public Keys\n====================\n%s\n", publicKeys));
    }

    private void createPublicKey() throws Exception {
        String name = "Public Key";
        String key = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAgZqr+BXGwQWe5UMY5CLM6a+XbFIZT0CAy/hx8Adhlb0PrwiQ9w4NNy9YMGTyvVTRyKBRgEjFNTJKBBDPFpWJyMa5BmL3JKmGZIYyWaggAILC2QbnEo2GqKbGfys3kiD/HfKCbxwohhNLieI+ULXw46IIriUEQCtx+AZyYTr620E26u1ANMvKzJLZQxTawUDNgy9S/YHSpMMftTF3LbEK5F2J33tLEbRBOVY4fvPL8w3YCx1Wu911+xz7UyVjdLDn26YoSl7+Fz5zZdwdhRMr+hDF8CInhbtAb1/cptFW4VBFVjDmHWn61bHUITbLWK5WRUzYoFWso4yOFYuq7JSMVYBKJE+27aMKZgPWiVrYaZVROxWoge7H//O+/NpWhyj9/K2Mzo6QzcLPTmw/1KN7CvIFIXDo+5wNZ+XFHuDeOaWrd2sMKvqXpEusdZYiuxy0e7Sze8/O5ada3BgFiM50DR1AIjZGONKEfAi2cGRXpBfCBUAU64RMeevobkrDzOSXCDy19o9wTfk4eRiWsuPIGm6zsJqA73+dW0KcSylBF5eaoPQbw/8WJjWClqlpQLfiKwnL2mjk6oFDAtVBfeRNjwd7Dyy1TvdbRJ5QwkfSHuwU2TphwPu/uMRJPOxvtMwgC3LXKnFEB2O9EzEDCrPmv6rOJn1i0tByDcNT0gL49MMCAwEAAQ==";
        boolean activated = true;
        PublicKey publicKey = nectar.getPublicKeysFactory()
                .createPublicKey(name, key, activated);
        System.out.println(String.format("Create Public Key\n====================\n%s\n", publicKey));
    }

    private void activatePublicKey() throws Exception {
        nectar.getPublicKeysFactory().activatePublicKey("d97bf39e-94ce-4fe9-8057-02d97eb3cbca");
        System.out.println("Activate Public Key\n====================\n");
    }

    private void deactivatePublicKey() throws Exception {
        nectar.getPublicKeysFactory().deactivatePublicKey("d97bf39e-94ce-4fe9-8057-02d97eb3cbca");
        System.out.println("Deactivate Public Key\n====================\n");
    }

    private void getNotifications() throws Exception {
        List<Notification> notifications = nectar.getNotificationsFactory().getNotifications();
        System.out.println(String.format("Get Notifications\n====================\n%s\n", notifications));
    }

    private void setNotificationsReadStatus() throws Exception {
        System.out.println("Set Notification Read Status\n====================\n");
        nectar.getNotificationsFactory().setNotificationReadStatus("931ef4e4-b375-40d8-b58e-c1874792ce64", true, Instant.now().toEpochMilli());
    }

    private void getCredits() throws Exception {
        Credits credits = nectar.getCreditsFactory().getCredits();
        System.out.println(String.format("Get Credits\n====================\n%s\n", credits));
    }

    private void getTransactions() throws Exception {
        Credits transactions = nectar.getCreditsFactory().getTransactions();
        System.out.println(String.format("Get Credits\n====================\n%s\n", transactions));
    }

    private void getCredentials() throws Exception {
        Credentials credentials = nectar.getCredentialsFactory().getCredentials("d41879ff-cb85-4bef-89a1-6c3cd7e2dd58");
        System.out.println(String.format("Get Credentials\n====================\n%s\n", credentials));
    }

    private void activateCredentials() throws Exception {
        System.out.println("Activate Credentials\n====================\n");
        nectar.getCredentialsFactory().activateCredentials("d1978978-5535-4c37-b4de-b05dbe2f09d4");
    }

    private void deactivateCredentials() throws Exception {
        System.out.println("Deactivate Credentials\n====================\n");
        nectar.getCredentialsFactory().deactivateCredentials("d1978978-5535-4c37-b4de-b05dbe2f09d4");
    }

    public void getUtilities() throws Exception {
        List<Utility> utilities = nectar.getUtilitiesFactory().getUtilities();
        System.out.println(String.format("Get Utilities\n====================\n%s\n", utilities));
    }

    public void getUtility() throws Exception {
        Utility utility = nectar.getUtilitiesFactory().getUtility("d61dd3e7-f749-4095-8bce-7d0aded8ff06");
        System.out.println(String.format("Get Utility\n====================\n%s\n", utility));
    }

    public void getMetersForUtility() throws Exception {
        List<Meter> meters = nectar.getUtilitiesFactory().getUtilityMeters("f5aec413-0fd7-4be9-bbc8-1dbe801a8bde");
        System.out.println(String.format("Get Meters for Utility\n====================\n%s\n", meters));
    }

    private void createUtility() throws Exception {
        String name = "api utility 2";
        String contactPhoneNo = "3214123427";
        Double unitCharge = 15d;
        boolean activated = true;
        String configRef = "cbf43d1f-8c2d-44a0-95a9-9c3c13ec846c";
        List<Meter> meters = new ArrayList<>();

        String createdUserRef = nectar.getUtilitiesFactory()
                .createUtility(name, contactPhoneNo, unitCharge, activated, configRef, meters);
        System.out.println(String.format("Create Utility\n====================\nRef: %s\n", createdUserRef));
    }

    private void updateUtility() throws Exception {
        String utilityRef = "86e6af22-5a9e-43c4-b1ad-730f4f22f3e5";
        String name = "api utility 2";
        String contactPhoneNo = "3214123427";
        Double unitCharge = 15d;
        boolean activated = true;
        String configRef = "cbf43d1f-8c2d-44a0-95a9-9c3c13ec846c";
        List<Meter> meters = new ArrayList<>();

        String updatedUtilityRef = nectar.getUtilitiesFactory().updateUtility(utilityRef, name, contactPhoneNo, unitCharge, activated, configRef, meters);
        System.out.println(String.format("Update Utility\n====================\nRef: %s\n", updatedUtilityRef));
    }

    private void activateUtility() throws Exception {
        System.out.println("Activate Utility\n====================\n");
        nectar.getUtilitiesFactory().activateUtility("86e6af22-5a9e-43c4-b1ad-730f4f22f3e5");
    }

    private void deactivateUtility() throws Exception {
        System.out.println("Deactivate Utility\n====================\n");
        nectar.getUtilitiesFactory().deactivateUtility("86e6af22-5a9e-43c4-b1ad-730f4f22f3e5");
    }

    public void getMeter() throws Exception {
        Meter meter = nectar.getMetersFactory().getMeter("b2392567-83b3-42ff-8865-d1a502c30939");
        System.out.println(String.format("Get Meter\n====================\n%s\n", meter));
    }

    private void createMeter() throws Exception {
        BigDecimal no = new BigDecimal("46297258900");
        boolean activated = false;
        String meterTypeRef ="00b20a3c-447d-4e9f-a484-c7a2e28e2d43";
        String utilityRef = "86e6af22-5a9e-43c4-b1ad-730f4f22f3e5";
        String subscriberRef = "ffc7a386-c4a7-4ebd-9eb8-d0bc32f30e66";

        String createdMeterRef = nectar.getMetersFactory().createMeter(no, activated, meterTypeRef, utilityRef, subscriberRef);
        System.out.println(String.format("Create Meter\n====================\nRef: %s\n", createdMeterRef));
    }

    private void updateMeter() throws Exception {
        String meterRef = "0d180ba9-44da-4395-9b1e-4c9666977cc6";
        BigDecimal no = new BigDecimal("46297251905");
        boolean activated = true;
        String meterTypeRef = "00b20a3c-447d-4e9f-a484-c7a2e28e2d43";
        String utilityRef = "86e6af22-5a9e-43c4-b1ad-730f4f22f3e5";
        String subscriberRef = "ffc7a386-c4a7-4ebd-9eb8-d0bc32f30e66";

        String updatedUserRef = nectar.getMetersFactory().updateMeter(meterRef, no, activated, meterTypeRef, utilityRef, subscriberRef);
        System.out.println(String.format("Update Meter\n====================\nRef: %s\n", updatedUserRef));
    }

    private void activateMeter() throws Exception {
        System.out.println("Activate Meter\n====================\n");
        nectar.getMetersFactory().activateMeter("0d180ba9-44da-4395-9b1e-4c9666977cc6");
    }

    private void deactivateMeter() throws Exception {
        System.out.println("Deactivate Meter\n====================\n");
        nectar.getMetersFactory().deactivateMeter("0d180ba9-44da-4395-9b1e-4c9666977cc6");
    }

    public void getSubscriber() throws Exception {
        Subscriber subscriber = nectar.getSubscribersFactory().getSubscriber("ffc7a386-c4a7-4ebd-9eb8-d0bc32f30e66");
        System.out.println(String.format("Get Subscriber\n====================\n%s\n", subscriber));
    }

    private void createSubscriber() throws Exception {
        String name = "new subscriber name";
        String phoneNo = "45234543254325";
        boolean activated = false;

        String createdSubscriberRef = nectar.getSubscribersFactory().createSubscriber(name, phoneNo, activated);
        System.out.println(String.format("Create Subscriber\n====================\nRef: %s\n", createdSubscriberRef));
    }

    private void updateSubscriber() throws Exception {
        String ref = "e580033f-1230-4638-be01-564ed514a751";
        String name = "updated subscriber name";
        String phoneNo = "45234543254325";
        boolean activated = false;

        String updatedSubscriberRef = nectar.getSubscribersFactory().updateSubscriber(ref, name, phoneNo, activated);
        System.out.println(String.format("Update Subscriber\n====================\nRef: %s\n", updatedSubscriberRef));
    }

    private void activateSubscriber() throws Exception {
        System.out.println("Activate Subscriber\n====================\n");
        nectar.getSubscribersFactory().activateSubscriber("e580033f-1230-4638-be01-564ed514a751");
    }

    private void deactivateSubscriber() throws Exception {
        System.out.println("Deactivate Subscriber\n====================\n");
        nectar.getSubscribersFactory().deactivateSubscriber("e580033f-1230-4638-be01-564ed514a751");
    }

    private void getConfiguration() throws Exception {
        Configuration configuration = nectar.getConfigurationsFactory().getConfiguration("47693f75-b77f-4280-b00f-9c0d90111a63", true);
        System.out.println(String.format("Get Configurations\n====================\n%s\n", configuration));
    }

    public void createConfiguration() throws Exception {
        String yamlConfig = "---\n" +
                "name: example_native_config\n" +
                "key_expiry_no: 255\n" +
                "encryption_algorithm: sta\n" +
                "token_carrier_type: numeric\n" +
                "decoder_key_generation_algorithm: 04\n" +
                "tariff_index: 01\n" +
                "key_revision_no: 1\n" +
                "vending_key: 0123456789abcdef\n" +
                "supply_group_code: 123456\n" +
                "key_type: 3\n" +
                "base_date: 2035\n" +
                "issuer_identification_no: 600727";
        String symmetricKey = "v8y/B?E(H+MbQeTh";
        String privateKey = "\"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\";";

        Configuration configuration = nectar.getConfigurationsFactory()
                .createConfiguration(yamlConfig, symmetricKey, privateKey);
        System.out.println(String.format("Create Configuration\n====================\n%s\n", configuration));
    }

    public void activateConfiguration() throws Exception {
        System.out.println("Activate Configuration\n====================\n");
        nectar.getConfigurationsFactory().activateConfiguration("ac3380d8-5d85-4161-92e5-03c1dc62de3d");

    }

    public void deactivateConfiguration() throws Exception {
        System.out.println("Deactivate Configuration\n====================\n");
        nectar.getConfigurationsFactory().deactivateConfiguration("ac3380d8-5d85-4161-92e5-03c1dc62de3d");
    }
}

```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
