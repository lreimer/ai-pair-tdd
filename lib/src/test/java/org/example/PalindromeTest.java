package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    @Test
    void shouldReturnTrueForAnna() {
        assertTrue(Palindrome.check("anna"));
    }

    @Test
    void shouldReturnFalseForAbba() {
        assertFalse(Palindrome.check("Abba"));
    }

    @Test
    void shouldReturnTrueForAba() {
        assertTrue(Palindrome.check("aba"));
    }

    @Test
    void shouldReturnTrueForSingleCharacterA() {
        assertTrue(Palindrome.check("A"));
    }

    @Test
    void shouldReturnTrueForSingleCharacterLowercase() {
        assertTrue(Palindrome.check("a"));
    }

    @Test
    void shouldReturnTrueForTwoCharacterPalindrome() {
        assertTrue(Palindrome.check("aa"));
    }

    @Test
    void shouldReturnFalseForTwoCharacterNonPalindrome() {
        assertFalse(Palindrome.check("ab"));
    }

    @Test
    void shouldReturnFalseForNull() {
        assertFalse(Palindrome.check(null));
    }

    @Test
    void shouldReturnTrueForEmptyString() {
        assertTrue(Palindrome.check(""));
    }

    @Test
    void shouldReturnTrueForLongPalindrome() {
        String longPalindrome = "a".repeat(10000) + "b" + "a".repeat(10000);
        assertTrue(Palindrome.check(longPalindrome));
    }

    @Test
    void shouldReturnFalseForLongNonPalindrome() {
        String longNonPalindrome = "a".repeat(10000) + "bc" + "a".repeat(10000);
        assertFalse(Palindrome.check(longNonPalindrome));
    }
}
