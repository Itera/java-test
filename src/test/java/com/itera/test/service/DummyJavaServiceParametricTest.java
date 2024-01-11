package com.itera.test.service;

import java.util.stream.Stream;

import com.itera.test.repository.DummyRepositoryImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DummyJavaServiceParametricTest {
    private DummyJavaService service;

    @ParameterizedTest
    @MethodSource("valuesForTest")
    void testService(int a, int b, int expected) {
        Assertions.assertEquals(expected, service.complexCalculation(a, b));
    }

    static Stream<Arguments> valuesForTest() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(2, 2, 4),
                Arguments.of(1, 12, 13),
                Arguments.of(27, -1, 26)
        );
    }

    @BeforeEach
    void setup() {
        this.service = new DummyJavaService(new DummyRepositoryImpl());
    }
}
