package yuntongxun4j.api;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

import java.util.Map;

public interface SmsResource  {
    public HttpResponse<JsonNode> sendSMS(String templateId, String to, Map<String, Object> params);
}
