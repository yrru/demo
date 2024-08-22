package org.example.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Xie Ya Ru
 */
public class TypeConversion {

  private ObjectMapper mapper = new ObjectMapper();

  public <T> T strToPojo(String str, Class<T> tClass) {
    T tPojo = null;
    try {
      tPojo = mapper.readValue(str, tClass);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return tPojo;
  }

  public String pojoToStr(Object pojo) {
    String str = null;
    try {
      str = mapper.writeValueAsString(pojo);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return str;
  }

  public <T> T jsonNodeToPojo(JsonNode jsonNode, Class<T> tClass) {
    T tPojo = null;
    try {
      tPojo = mapper.treeToValue(jsonNode, tClass);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return tPojo;
  }
}
