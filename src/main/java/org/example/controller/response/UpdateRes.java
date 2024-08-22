package org.example.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Xie Ya Ru
 */
@Data
public class UpdateRes {

  @JsonProperty("Code")
  private String code;
  @JsonProperty("Name")
  private String name;
}
