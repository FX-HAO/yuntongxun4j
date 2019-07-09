package yuntongxun4j.conf;

/**
 * Configuration base class with default settings.
 *
 * @author Fuxin Hao
 */
public abstract class BaseConfiguration implements Configuration {
    private String gateway = "https://app.cloopen.com:8883";
    private String accountSid = null;
    private String authToken = null;
    private String appId = null;

    @Override
    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @Override
    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    @Override
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
