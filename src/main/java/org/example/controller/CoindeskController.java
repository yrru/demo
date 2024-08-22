package org.example.controller;

import org.example.common.ApiUtil;
import org.example.model.CurrentpriceModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie Ya Ru
 */
@RestController
public class CoindeskController {

  @GetMapping("coindesk")
  public CurrentpriceModel getData() {
    return ApiUtil.sendCoindesk();
  }
}
