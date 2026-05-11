package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Computes the prime factorization of a positive integer.
 *
 * <p>This class implements Robert C. Martin's classic Prime Factors kata.
 * Given a positive integer {@code n}, {@link #generate(int)} returns the
 * list of prime numbers whose product equals {@code n}, in non-decreasing
 * order.
 *
 * <p>By convention, the prime factorization of {@code 1} is the empty list,
 * since {@code 1} has no prime factors.
 */
public class PrimeFactors {

    /**
     * Generates the prime factorization of the given positive integer.
     *
     * <p>Examples:
     * <ul>
     *   <li>{@code generate(1)} returns {@code []}</li>
     *   <li>{@code generate(2)} returns {@code [2]}</li>
     *   <li>{@code generate(12)} returns {@code [2, 2, 3]}</li>
     *   <li>{@code generate(13)} returns {@code [13]}</li>
     * </ul>
     *
     * @param number the positive integer to factorize (must be {@code >= 1})
     * @return the list of prime factors in non-decreasing order; empty for {@code 1}
     * @throws IllegalArgumentException if {@code number} is less than 1
     */
    public List<Integer> generate(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number must be greater than or equal to 1");
        }

        List<Integer> primes = new ArrayList<>();
        int remaining = number;
        for (int candidate = 2; remaining > 1; candidate++) {
            while (remaining % candidate == 0) {
                primes.add(candidate);
                remaining /= candidate;
            }
        }
        return primes;
    }
}
