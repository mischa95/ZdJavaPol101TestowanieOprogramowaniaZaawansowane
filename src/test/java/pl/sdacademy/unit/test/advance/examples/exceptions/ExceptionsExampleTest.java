package pl.sdacademy.unit.test.advance.examples.exceptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionsExampleTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde"})
    void shouldReturnExceptionIfInputIsNullOrEmpty(String input) {
        //when&then
        //JUnit5
        assertThrows(IllegalArgumentException.class,
                () -> ExceptionsExample.someMagicOperation(input),
                "cos nie pykło");
        //AssertJ
        assertThatThrownBy(() -> ExceptionsExample.someMagicOperation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("String cannot have length equal 5");
    }
}