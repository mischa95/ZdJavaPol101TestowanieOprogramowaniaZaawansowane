package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    @ParameterizedTest
    @CsvSource({
            "kajak, true", "java, false",
            "kobyla ma maly bok, true",
            "zakopane na pokaz, True"
    })
    void shouldVerifyIfStringIsPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); //jUnit
        assertThat(result).isEqualTo(expectedResult); //asertJ
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void shouldVerifyIfStringIsPalindrome_ByCsvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); //jUnit
        assertThat(result).isEqualTo(expectedResult); //asertJ
    }

}