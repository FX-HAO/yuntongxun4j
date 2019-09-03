package yuntongxun4j.api;

import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public interface SmsResource  {
    public Response sendSMS(String templateId, String to, Map<String, Object> params) throws IOException;
}
