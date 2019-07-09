package yuntongxun4j;

import com.google.gson.Gson;
import kong.unirest.*;
import yuntongxun4j.api.SmsResource;
import yuntongxun4j.conf.Configuration;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class YunTongXunImpl implements YunTongXun {
    private Configuration conf;

    public YunTongXunImpl(Configuration conf) {
        this.conf = conf;
    }

    protected String getURL(String path) {
        return conf.getGateway() + "/2013-12-26/Accounts/" + conf.getAccountSid() + path;
    }

    public HttpResponse<JsonNode> api(String path, Map<String, Object> params) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        df.setTimeZone(TimeZone.getTimeZone("Beijing"));
        String batch = df.format(new Date());
        String signature = String.format("%s%s%s", conf.getAccountSid(), conf.getAuthToken(), batch);

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            // do nothing
        }
        byte[] digest = md.digest(signature.getBytes());
        String sig = DatatypeConverter.printHexBinary(digest).toUpperCase();

        String auth = Base64.getEncoder().encodeToString(String.format("%s:%s", conf.getAccountSid(), batch).getBytes());
        params.put("appId", conf.getAppId());
        Gson gson = new Gson();
        HttpResponse<JsonNode> res = Unirest.post(getURL(path))
                .header("accept", "application/json")
                .header("content-type", "application/json;charset=utf-8")
                .header("authorization", auth)
                .queryString("sig", sig)
                .body(gson.toJson(params))
                .asJson();
        return res;
    }

    @Override
    public HttpResponse<JsonNode> sendSMS(String templateId, String to, Map<String, Object> params) {
        params.put("templateId", templateId);
        params.put("to", to);
        return api("/SMS/TemplateSMS", params);
    }

    @Override
    public SmsResource sms() {
        return this;
    }
}
