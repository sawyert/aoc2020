package com.tim.aoc2020.day15;

import java.util.ArrayList;
import java.util.List;

public class Day15 {

    private String[] inputSplit;
    private List<Integer> results = new ArrayList<>();
    private long max;

    public Day15(String input, long max) {
        this.inputSplit = input.split(",");
        this.max = max;
    }

    public long execute() {
        for (int i=0; i<max; i++) {
            if (i < inputSplit.length) {
                results.add(Integer.parseInt(inputSplit[i]));
                continue;
            }

            int lastNumber = results.get(i-1);
            long countOfLastNumber = results.stream().filter(x -> x == lastNumber).count();
            if (countOfLastNumber == 1) {
                results.add(0);
                continue;
            }

            int foundPosition = 0;
            for (int j=results.size() - 2 ; j>=0 ; j--) {
                if (results.get(j) == lastNumber) {
                    foundPosition = j;
                    break;
                }
            }

            int newValue = i - 1 - foundPosition;
            results.add(newValue);

            int resultsSize = results.size();
            if (resultsSize % 10000 == 0) {
                System.out.println(results.size());
            }
        }

        return this.results.get(this.results.size()-1);
    }

}
