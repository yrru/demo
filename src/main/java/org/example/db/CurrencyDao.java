package org.example.db;

import java.util.List;
import java.util.Optional;
import org.example.db.entity.CurrencyEntity;
import org.example.db.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xie Ya Ru
 */
@Service
public class CurrencyDao {

  @Autowired
  CurrencyRepository repository;

  public List<CurrencyEntity> findAll() {
    return repository.findAll();
  }

  public Optional<CurrencyEntity> findById(String id) {
    return repository.findById(id);
  }

  public CurrencyEntity save(CurrencyEntity currency) {
    return repository.save(currency);
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
