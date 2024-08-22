package org.example.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Xie Ya Ru
 */
@Table(name = "CURRENCY")
@Entity
@Setter
@Getter
public class CurrencyEntity {

  @Id
  @Column(name = "CODE")
  private String code;
  @Column(name = "NAME")
  private String name;
}
