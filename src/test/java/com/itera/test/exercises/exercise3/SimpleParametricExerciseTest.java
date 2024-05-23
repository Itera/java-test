
package com.itera.test.exercises.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleParametricExerciseTest {
    int calculate() {
        return 3 + 2;
    }

    // Exercise - convert the following test to parametric using method source

    // Test multiple calculations

    @Test
    void simpleJUnitUnitTest() {
        // Business logic
        int result = calculate();

        // Test
        assertEquals(result, 5);
    }
}
