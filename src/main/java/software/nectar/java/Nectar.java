package software.nectar.java;

import software.nectar.java.factory.*;

/**
 * Entry point to the Nectar API Java SDK.
 *
 * @author Reagan Mbitiru (reagan@nectar.software)
 *
 */
public class Nectar {

    private String key;
    private String secret;

    private String host;

    public Nectar(String key, String secret, String host) {
        setKey(key);
        setSecret(secret);
        setHost(host);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String  getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public TokensFactory getTokenFactory() {
        return new TokensFactory(key, secret, host);
    }

    public UsersFactory getUsersFactory() {
        return new UsersFactory(key, secret, host);
    }

    public PublicKeysFactory getPublicKeysFactory() {
        return new PublicKeysFactory(key, secret, host);
    }

    public NotificationsFactory getNotificationsFactory() {
        return new NotificationsFactory(key, secret, host);
    }

    public CreditsFactory getCreditsFactory() {
        return new CreditsFactory(key, secret, host);
    }

    public CredentialsFactory getCredentialsFactory() {
        return new CredentialsFactory(key, secret, host);
    }

    public ConfigurationsFactory getConfigurationsFactory() {
        return new ConfigurationsFactory(key, secret, host);
    }

    public MetersFactory getMetersFactory() {
        return new MetersFactory(key, secret, host);
    }

    public SubscribersFactory getSubscribersFactory() {
        return new SubscribersFactory(key, secret, host);
    }

    public UtilitiesFactory getUtilitiesFactory() {
        return new UtilitiesFactory(key, secret, host);
    }
}
