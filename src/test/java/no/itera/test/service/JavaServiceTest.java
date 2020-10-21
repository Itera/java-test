package no.itera.test.service;

import no.itera.test.repository.FakeRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavaServiceTest {
  @Test
  void testCalculation() {
    JavaService service = new JavaService(new FakeRepository());

    Assertions.assertEquals(5, service.complexCalculation(2, 3));
  }
}
