package org.example;

/**
 * Utility class for checking if a string is a palindrome.
 * A palindrome is a string that reads the same forwards and backwards.
 */
public class Palindrome {

    private Palindrome() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Checks if the given string is a palindrome.
     * The check is case-sensitive.
     * 
     * @param input the string to check
     * @return {@code true} if the input is a palindrome, {@code false} otherwise
     *         (including null inputs)
     */
    public static boolean check(String input) {
        if (input == null) {
            return false;
        }
        
        return isPalindromeUsingTwoPointers(input);
    }

    private static boolean isPalindromeUsingTwoPointers(String input) {
        int left = 0;
        int right = input.length() - 1;
        
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
