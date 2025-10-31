package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    private Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    void shouldReturnTrueForAnna() {
        assertTrue(palindrome.check("anna"));
    }

    @Test
    void shouldReturnFalseForAbba() {
        assertFalse(palindrome.check("Abba"));
    }

    @Test
    void shouldReturnTrueForAba() {
        assertTrue(palindrome.check("aba"));
    }

    @Test
    void shouldReturnTrueForSingleCharacterA() {
        assertTrue(palindrome.check("A"));
    }

    @Test
    void shouldReturnFalseForNull() {
        assertFalse(palindrome.check(null));
    }

    @Test
    void shouldReturnTrueForEmptyString() {
        assertTrue(palindrome.check(""));
    }

    @Test
    void shouldReturnTrueForLongPalindrome() {
        String longPalindrome = "a".repeat(10000) + "b" + "a".repeat(10000);
        assertTrue(palindrome.check(longPalindrome));
    }

    @Test
    void shouldReturnFalseForLongNonPalindrome() {
        String longNonPalindrome = "a".repeat(10000) + "bc" + "a".repeat(10000);
        assertFalse(palindrome.check(longNonPalindrome));
    }
}
