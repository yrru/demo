package org.example.controller.requery;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Xie Ya Ru
 */
@Data
public class UpdateReq {

  @JsonProperty("Code")
  private String code;
  @JsonProperty("Name")
  private String name;
}
