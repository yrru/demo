package org.example.controller.requery;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Xie Ya Ru
 */
@Data
public class InsertReq {

  @JsonProperty("code")
  private String code;
  @JsonProperty("name")
  private String name;
}
