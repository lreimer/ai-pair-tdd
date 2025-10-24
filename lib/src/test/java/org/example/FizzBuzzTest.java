package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void shouldReturn1ForInput1() {
        assertEquals("1", fizzBuzz.convert(1));
    }

    @Test
    void shouldReturn2ForInput2() {
        assertEquals("2", fizzBuzz.convert(2));
    }

    @Test
    void shouldReturnFizzForInput3() {
        assertEquals("Fizz", fizzBuzz.convert(3));
    }

    @Test
    void shouldReturnBuzzForInput5() {
        assertEquals("Buzz", fizzBuzz.convert(5));
    }

    @Test
    void shouldReturnFizzBuzzForInput15() {
        assertEquals("FizzBuzz", fizzBuzz.convert(15));
    }

    @Test
    void shouldReturnFizzForInput6() {
        assertEquals("Fizz", fizzBuzz.convert(6));
    }

    @Test
    void shouldReturnBuzzForInput10() {
        assertEquals("Buzz", fizzBuzz.convert(10));
    }

    @Test
    void shouldReturnFizzBuzzForInput30() {
        assertEquals("FizzBuzz", fizzBuzz.convert(30));
    }

    @Test
    void shouldReturn7ForInput7() {
        assertEquals("7", fizzBuzz.convert(7));
    }

    @Test
    void shouldGenerateSingleElementForRange1To1() {
        assertEquals(List.of("1"), fizzBuzz.generate(1, 1));
    }

    @Test
    void shouldGenerateRangeFrom1To5() {
        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz"), fizzBuzz.generate(1, 5));
    }

    @Test
    void shouldGenerateRangeFrom1To15() {
        assertEquals(
            List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"),
            fizzBuzz.generate(1, 15)
        );
    }

    @Test
    void shouldGenerateRangeFrom10To20() {
        assertEquals(
            List.of("Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz"),
            fizzBuzz.generate(10, 20)
        );
    }
}