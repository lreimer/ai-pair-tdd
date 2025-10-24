package org.example;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public String convert(int number) {
        String result = "";
        if (number % 3 == 0) {
            result += "Fizz";
        }
        if (number % 5 == 0) {
            result += "Buzz";
        }
        return result.isEmpty() ? String.valueOf(number) : result;
    }

    public List<String> generate(int from, int to) {
        List<String> result = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            result.add(convert(i));
        }
        return result;
    }
}