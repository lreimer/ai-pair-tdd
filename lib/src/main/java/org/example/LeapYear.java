package org.example;

/**
 * Determines whether a given year in the Gregorian calendar is a leap year.
 *
 * <p>A year is a leap year if it is divisible by 4, except for end-of-century
 * years, which must be divisible by 400. This means:
 * <ul>
 *   <li>2000 is a leap year (divisible by 400)</li>
 *   <li>1900 is not a leap year (divisible by 100 but not 400)</li>
 *   <li>2024 is a leap year (divisible by 4 but not 100)</li>
 *   <li>2023 is not a leap year (not divisible by 4)</li>
 * </ul>
 */
public class LeapYear {

    /**
     * Returns whether the given year is a leap year.
     *
     * @param year the year to check (must be greater than 0)
     * @return {@code true} if the year is a leap year, {@code false} otherwise
     * @throws IllegalArgumentException if the year is less than or equal to 0
     */
    public boolean isLeapYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be greater than 0");
        }
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}
