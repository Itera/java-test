package com.itera.test.exercises.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleJunitAssertionExerciseTest {
    int calculate() {
        return 3 + 2;
    }

    @Test
    void simpleAssertJUnitTest() {
        // Business logic
        int result = calculate();

        // Test
        assertEquals(result, 5);
    }
}
