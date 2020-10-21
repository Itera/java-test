package no.itera.test.repository;

import java.util.List;

import no.itera.test.domain.TestData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TestDataRepositoryTest {
  @Autowired
  private TestDataRepository repository;

  @Test
  void dataWasLoaded() {
    List<TestData> items = repository.findAll();

    Assertions.assertEquals(5, items.size());
  }
}
