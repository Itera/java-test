package com.itera.test.exercises.exercise2;

import org.junit.jupiter.api.Test;

public class SimpleJunitAssertionExerciseTest {
    int calculate() {
        return 3 + 2;
    }

    // Exercise - complete the test using assertj assertion on equality

    @Test
    void simpleAssertJUnitTest() {
        // Business logic
        int result = calculate();

        // Test
    }

    // Exercise - explore other assertions provided by assertj
}
