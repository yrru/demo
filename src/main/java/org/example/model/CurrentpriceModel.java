package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @author Xie Ya Ru
 */
@Data
public class CurrentpriceModel {

  @JsonProperty("time")
  private Time time;
  @JsonProperty("disclaimer")
  private String disclaimer;
  @JsonProperty("chartName")
  private String chartName;
  @JsonProperty("bpi")
  private JsonNode bpi;

  @Data
  public static class Time {
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("updatedISO")
    private String updatedISO;
    @JsonProperty("updateduk")
    private String updatedUk;
  }

  @Data
  public static class Bpi {
    @JsonProperty("code")
    private String code;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("rate")
    private String rate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("rate_float")
    private String rateFloat;
  }
}
