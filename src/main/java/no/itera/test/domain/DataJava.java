package no.itera.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DataJava {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String value;

  public DataJava() {
    this.id = null;
    this.value = null;
  }

  public DataJava(Long id, String value) {
    this.id = id;
    this.value = value;
  }

  public Long getId() {
    return id;
  }

  public String getValue() {
    return value;
  }
}
