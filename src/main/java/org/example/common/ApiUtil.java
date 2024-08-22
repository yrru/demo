package org.example.common;

import java.nio.charset.StandardCharsets;
import org.example.model.CurrentpriceModel;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author Xie Ya Ru
 */
public class ApiUtil {

  public static String sendGet(String url) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    return restTemplate.getForObject(url, String.class);
  }

  public static CurrentpriceModel sendCoindesk() {
    TypeConversion tc = new TypeConversion();
    String result = ApiUtil.sendGet("https://api.coindesk.com/v1/bpi/currentprice.json");
    return tc.strToPojo(result, CurrentpriceModel.class);
  }
}
