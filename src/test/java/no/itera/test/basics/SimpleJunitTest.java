package no.itera.test.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleJunitTest {
  @Test
  void simpleJUnitUnitTest() {
    // Business logic
    int result = 3 + 2;

    // Test
    assertEquals(result, 5);
  }
}
