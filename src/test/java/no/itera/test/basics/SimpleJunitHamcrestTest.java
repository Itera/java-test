package no.itera.test.basics;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class SimpleJunitHamcrestTest {
  @Test
  void simpleJUnitUnitTest() {
    // Business logic
    int result = 3 + 2;

    // Test
    assertThat(result, equalTo(5));
  }
}
