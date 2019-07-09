package yuntongxun4j.conf;

import java.util.Properties;

public class PropertyConfiguration extends BaseConfiguration {
    private static final String GATEWAY = "gateway";
    private static final String ACCOUNT_SID = "account_sid";
    private static final String AUTH_TOKEN = "auth_token";
    private static final String APP_ID = "app_id";

    public void setProperties(Properties props) {
        if (props.getProperty(GATEWAY) != null) {
            setGateway(props.getProperty(GATEWAY));
        }

        if (props.getProperty(ACCOUNT_SID) != null) {
            setAccountSid(props.getProperty(ACCOUNT_SID));
        }

        if (props.getProperty(AUTH_TOKEN) != null) {
            setAuthToken(props.getProperty(AUTH_TOKEN));
        }

        if (props.getProperty(APP_ID) != null) {
            setAppId(props.getProperty(APP_ID));
        }
    }
}
