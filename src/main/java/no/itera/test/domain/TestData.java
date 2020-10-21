package no.itera.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String value;

  public Long getId() {
    return id;
  }

  public String getValue() {
    return value;
  }
}
