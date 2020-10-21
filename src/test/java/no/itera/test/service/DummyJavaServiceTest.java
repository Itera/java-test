package no.itera.test.service;

import no.itera.test.repository.DummyRepositoryImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DummyJavaServiceTest {
  @Test
  void testCalculation() {
    DummyJavaService service = new DummyJavaService(new DummyRepositoryImpl());

    Assertions.assertEquals(5, service.complexCalculation(2, 3));
  }
}
