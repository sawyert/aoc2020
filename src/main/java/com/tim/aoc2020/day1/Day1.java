package com.tim.aoc2020.day1;

public class Day1 {
    String[] input;

    public Day1(String[] testInput) {
        this.input = testInput;
    }

    public long execute() {
        for (int i=0; i<input.length; i++) {
            for (int j=i+1; j<input.length; j++) {
                long num1 = Long.parseLong(input[i]);
                long num2 = Long.parseLong(input[j]);

                long sum = num1 + num2;
                if (sum == 2020) {
                    return num1 * num2;
                }
            }
        }

        throw new UnsupportedOperationException("Ran off end of loop");
    }
}
