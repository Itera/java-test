package no.itera.test.basics;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SimpleParametricTest {
    @ParameterizedTest
    @MethodSource("valuesForTest")
    void simpleTest(int x, int y, int expectedResult) {
        // Business logic
        int result = x + y;

        // Test
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> valuesForTest() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(2, 2, 4),
                Arguments.of(1, 12, 13),
                Arguments.of(27, -1, 26)
        );
    }
}
