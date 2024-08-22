package org.example.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author Xie Ya Ru
 */
@Data
public class QueryRes {

  @JsonProperty("Currencies")
  private List<Currency> currencies = new ArrayList<>();

  @lombok.Data
  public static class Currency {
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
  }
}
