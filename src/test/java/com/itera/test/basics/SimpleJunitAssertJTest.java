package com.itera.test.basics;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SimpleJunitAssertJTest {
    int calculate() {
        return 3 + 2;
    }

    @Test
    void simpleJUnitUnitTest() {
        // Business logic
        int result = calculate();

        // Test
        assertThat(result).isEqualTo(5);
    }
}
