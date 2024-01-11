package com.itera.test.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleJunitTest {
    int calculate() {
        return 3 + 2;
    }

    @Test
    void simpleJUnitUnitTest() {
        // Business logic
        int result = calculate();

        // Test
        assertEquals(result, 5);
    }
}
