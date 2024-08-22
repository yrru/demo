package org.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.example.common.ApiUtil;
import org.example.common.TypeConversion;
import org.example.controller.response.NewCoindeskRes;
import org.example.controller.response.NewCoindeskRes.Currency;
import org.example.db.CurrencyDao;
import org.example.db.entity.CurrencyEntity;
import org.example.model.CurrentpriceModel;
import org.example.model.CurrentpriceModel.Bpi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie Ya Ru
 */
@RestController
public class NewCoindeskController {

  @Autowired
  CurrencyDao dao;

  @GetMapping("/newCoindesk")
  public NewCoindeskRes getData() {
    TypeConversion tc = new TypeConversion();
    CurrentpriceModel model = ApiUtil.sendCoindesk();
    Date date = new Date(model.getTime().getUpdated());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String dateFm = sdf.format(date);
    NewCoindeskRes res = new NewCoindeskRes();
    res.setUpdated(dateFm);
    model.getBpi().forEach(jsonNode -> {
      Bpi bpi = tc.jsonNodeToPojo(jsonNode, Bpi.class);
      Currency currency = new Currency();
      currency.setCode(bpi.getCode());
      currency.setRate(bpi.getRate());
      Optional<CurrencyEntity> oEntity = dao.findById(bpi.getCode());
      oEntity.ifPresent(currencyEntity -> currency.setName(currencyEntity.getName()));
      res.getCurrencies().add(currency);
    });
    return res;
  }
}
