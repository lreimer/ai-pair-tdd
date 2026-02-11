package org.example;

public class RomanNumerals {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String convert(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number must be between 1 and 3999");
        }

        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (int i = 0; i < VALUES.length; i++) {
            while (remaining >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                remaining -= VALUES[i];
            }
        }

        return result.toString();
    }
}
