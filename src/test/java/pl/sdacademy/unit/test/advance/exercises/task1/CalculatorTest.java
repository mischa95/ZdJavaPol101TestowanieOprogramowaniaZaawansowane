package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @MethodSource("provideDataForSubtract")
    void shouldSubtractTwoDigits(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = calculator.subtract(firstDigit, secondDigit);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertj
    }

    @Test
    void shouldThrowExceptionWhenSecondDigitIsZero() {
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(5 ,0)); //junit
        assertThatThrownBy(() -> calculator.divide(5, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("can't divide by 0!"); //assertj
    }

    static Stream<Arguments> provideDataForSubtract() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(4, 2, 2),
                Arguments.of(-5, -2, -3)
        );
    }

}