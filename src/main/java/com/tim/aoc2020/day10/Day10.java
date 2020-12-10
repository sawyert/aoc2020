package com.tim.aoc2020.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {
    private String[] input;
    private List<Integer> adapterList = new ArrayList<>();
    private List<Integer> sortedList;

    public Day10(String[] input) {
        this.input = input;

        for (String line : input) {
            Integer lineNumber = Integer.parseInt(line);
            adapterList.add(lineNumber);
            sortedList = adapterList.stream().sorted().collect(Collectors.toList());
        }
    }

    public long execute() {
        int threeCount = 0;
        int oneCount =  0;
        for (int i=0; i<sortedList.size(); i++) {
            int thisEntry = sortedList.get(i);
            int previousEntry = 0;
            if (i > 0) {
                previousEntry = sortedList.get(i-1);
            }
            int difference = thisEntry - previousEntry;

            if (difference == 3) {
                threeCount++;
            }

            if (difference == 1) {
                oneCount++;
            }

            if (difference > 3) {
                throw new UnsupportedOperationException("Difference exceeds three");
            }
        }

        threeCount += 1; // add one for device

        return threeCount * oneCount;
    }

    public long execute2() {
        List<Integer> fullList = new ArrayList<>();
        fullList.add(0);
        fullList.addAll(sortedList);
        fullList.add(sortedList.get(sortedList.size()-1) + 3);

        List<Integer> gaps = new ArrayList<>();
        for (int i=1; i<fullList.size(); i++) {
            int thisEntry = fullList.get(i);
            int previousEntry =  fullList.get(i - 1);
            int difference = thisEntry - previousEntry;
            gaps.add(difference);
        }

        StringBuilder differenceString = new StringBuilder();
        for (int i=0; i<gaps.size(); i++) {
            differenceString.append(gaps.get(i));
        }
        System.out.println(differenceString);

        String diff = differenceString.toString();
        diff = diff.replace("111111", "E");
        diff = diff.replace("11111", "D");
        diff = diff.replace("1111", "C");
        diff = diff.replace("111", "B");
        diff = diff.replace("11", "A");

        System.out.println(diff);

        long count = 1;
        for (int i=0; i<diff.length(); i++) {
            char letter = diff.charAt(i);
            switch (letter) {
                case 'A':
                    count *= 2;
                    break;
                case 'B':
                    count *= 4;
                    break;
                case 'C':
                    count *= 7;
                    break;
                case 'D':
                    count *= 13;
                    break;
                case 'E':
                    count *= 24;
                    break;
            }
        }

        return count;
    }
}
