package com.itera.test.basics;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class SimpleJunitHamcrestTest {
    int calculate() {
        return 3 + 2;
    }

    @Test
    void simpleJUnitUnitTest() {
        // Business logic
        int result = calculate();

        // Test
        assertThat(result, equalTo(5));
    }
}
