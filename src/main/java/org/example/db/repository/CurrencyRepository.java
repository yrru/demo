package org.example.db.repository;

import org.example.db.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Xie Ya Ru
 */
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {

}
