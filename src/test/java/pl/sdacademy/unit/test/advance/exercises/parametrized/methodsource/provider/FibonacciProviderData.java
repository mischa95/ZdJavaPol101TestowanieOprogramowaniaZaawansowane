package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class FibonacciProviderData {

    public static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(0, 0),
                Arguments.of(2, 1),
                Arguments.of(3, 2)
        );
    }
}
