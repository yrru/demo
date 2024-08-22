package org.example.controller;

import java.util.List;
import java.util.Optional;
import org.example.controller.requery.InsertReq;
import org.example.controller.requery.UpdateReq;
import org.example.controller.response.QueryRes;
import org.example.controller.response.QueryRes.Currency;
import org.example.controller.response.UpdateRes;
import org.example.db.CurrencyDao;
import org.example.db.entity.CurrencyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie Ya Ru
 */
@RestController
@RequestMapping("/currency")
public class CurrencyController {

  @Autowired
  CurrencyDao dao;

  @GetMapping("/query")
  public QueryRes query() {
    QueryRes res = new QueryRes();
    List<CurrencyEntity> entities = dao.findAll();

    entities.forEach(entity -> {
      Currency currency = new Currency();
      currency.setCode(entity.getCode());
      currency.setName(entity.getName());

      res.getCurrencies().add(currency);
    });

    return res;
  }

  @PostMapping("/insert")
  public void insert(@RequestBody InsertReq req) {
    CurrencyEntity entity = new CurrencyEntity();
    entity.setCode(req.getCode());
    entity.setName(req.getName());

    dao.save(entity);
  }

  @PutMapping("/update/{id}")
  public UpdateRes update(@PathVariable String id, @RequestBody UpdateReq req) {
    UpdateRes res = new UpdateRes();
    Optional<CurrencyEntity> idEntity = dao.findById(id);

    if (idEntity.isPresent()) {
      CurrencyEntity entity = idEntity.get();
      entity.setName(req.getName());

      CurrencyEntity sEntity = dao.save(entity);
      res.setCode(sEntity.getCode());
      res.setName(sEntity.getName());
    }

    return res;
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable String id) {
    Optional<CurrencyEntity> idEntity = dao.findById(id);
    idEntity.ifPresent(entity -> dao.delete(id));
  }
}
