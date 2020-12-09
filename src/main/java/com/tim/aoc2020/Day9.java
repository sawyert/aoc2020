package com.tim.aoc2020;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

public class Day9 {
    private String[] input;
    private int preambleSize;

    public Day9(String[] input, int preambleSize) {
        this.input = input;
        this.preambleSize = preambleSize;
    }

    public long execute() {

        for (int position = this.preambleSize; position < this.input.length; position++)
        {
            Long currentValue = Long.parseLong(this.input[position]);
            Long[] previousPreambleLines = this.fetchPreviousPreambleLines(position);

            boolean found = false;
            for (int i=0; i < previousPreambleLines.length; i++) {
                for (int j=i+1; j < previousPreambleLines.length; j++) {

                    Long num1 = previousPreambleLines[i];
                    Long num2 = previousPreambleLines[j];

                    if (num1 + num2 == currentValue) {
                        found = true;
                        break;
                    }
                }
                if (found) {break;}
            }

            if (!found) {
                return currentValue;
            }
        }

        throw new UnsupportedOperationException("Broken");
    }

    private Long[] fetchPreviousPreambleLines(int position) {
        Long[] previousLines = new Long[preambleSize];
        for (int i = 0; i < preambleSize; i++) {
            previousLines[i] = Long.parseLong(input[position-i-1]);
        }

        return previousLines;
    }

    public long execute2(int target) {
        for (int i=1; i<input.length; i++) {
            String line = input[i];
            Long number = Long.parseLong(line);
            Long total = number;

            List<Long> numbers = new ArrayList<>();
            numbers.add(number);
            for (int j=i-1; j>=0; j--) {
                String pastLine = input[j];
                Long pastNumber = Long.parseLong(pastLine);

                total += pastNumber;
                numbers.add(pastNumber);
                if (total == target) {

                    OptionalLong lowest = numbers.stream().mapToLong(v -> v).min();
                    OptionalLong highest = numbers.stream().mapToLong(v -> v).max();

                    Long lowestAndHighest = lowest.getAsLong() + highest.getAsLong();
                    return lowestAndHighest;
                }
                if (total > target) {
                    break;
                }
            }
        }
        throw new UnsupportedOperationException("Not found");
    }
}
