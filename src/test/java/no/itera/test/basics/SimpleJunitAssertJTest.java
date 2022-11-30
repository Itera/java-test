package no.itera.test.basics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleJunitAssertJTest {
    @Test
    void simpleJUnitUnitTest() {
        // Business logic
        int result = 3 + 2;

        // Test
        assertThat(result).isEqualTo(5);
    }
}
