package org.example;

/**
 * Converts decimal numbers to Roman numeral notation.
 * 
 * <p>This class provides conversion from Arabic decimal numbers to their
 * Roman numeral representation following standard notation including
 * subtractive notation (e.g., IV for 4, IX for 9).
 * 
 * <p>Supports numbers in the range 1-3999, which covers the standard
 * Roman numeral system without extended notation.
 */
public class RomanNumerals {

    private static final int[] VALUES = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    private static final String[] NUMERALS = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    /**
     * Converts a decimal number to its Roman numeral representation.
     * 
     * <p>Uses the standard Roman numeral symbols:
     * <ul>
     *   <li>I = 1</li>
     *   <li>V = 5</li>
     *   <li>X = 10</li>
     *   <li>L = 50</li>
     *   <li>C = 100</li>
     *   <li>D = 500</li>
     *   <li>M = 1000</li>
     * </ul>
     * 
     * <p>Subtractive notation is used for:
     * <ul>
     *   <li>IV = 4, IX = 9</li>
     *   <li>XL = 40, XC = 90</li>
     *   <li>CD = 400, CM = 900</li>
     * </ul>
     *
     * @param number the decimal number to convert (must be between 1 and 3999 inclusive)
     * @return the Roman numeral representation as a string
     * @throws IllegalArgumentException if the number is less than 1 or greater than 3999
     */
    public String convert(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }

        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (int i = 0; i < VALUES.length; i++) {
            while (remaining >= VALUES[i]) {
                result.append(NUMERALS[i]);
                remaining -= VALUES[i];
            }
        }

        return result.toString();
    }
}
