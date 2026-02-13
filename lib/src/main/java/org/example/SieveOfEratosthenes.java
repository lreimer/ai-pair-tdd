package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Sieve of Eratosthenes algorithm for finding prime numbers.
 * 
 * <p>The Sieve of Eratosthenes is an ancient algorithm for finding all prime
 * numbers up to a specified integer. It works by iteratively marking the
 * multiples of each prime number starting from 2, the smallest prime number.
 * 
 * <p>The algorithm is efficient for finding all primes up to a moderate limit,
 * with time complexity of O(n log log n) and space complexity of O(n).
 */
public class SieveOfEratosthenes {

    /**
     * Finds all prime numbers up to and including the specified integer n.
     * 
     * <p>The algorithm works as follows:
     * <ol>
     *   <li>Create a boolean array to track prime candidates from 2 to n</li>
     *   <li>Initially mark all numbers as potential primes</li>
     *   <li>For each prime found, mark all its multiples as non-prime</li>
     *   <li>Collect all numbers that remain marked as prime</li>
     * </ol>
     * 
     * @param n the upper limit (inclusive) for finding prime numbers
     * @return an immutable list of all prime numbers up to n, in ascending order
     * @throws IllegalArgumentException if n is negative
     */
    public List<Integer> findPrimes(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (n < 2) {
            return List.of();
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
