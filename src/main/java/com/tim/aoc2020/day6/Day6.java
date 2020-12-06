package com.tim.aoc2020.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {
    String[] inputArray;

    public Day6(String[] testInputArray) {
        this.inputArray = testInputArray;
    }

    public long execute() {
        List<Set<String>> allData = new ArrayList<>();

        Set<String> thisSet = new HashSet<>();
        for (String eachLine : inputArray) {

            if (eachLine.trim().length() == 0)
            {
                allData.add(thisSet);
                thisSet = new HashSet<>();
                continue;
            }

            char[] chars = eachLine.toCharArray();
            for (char eachChar: chars) {
                thisSet.add("" + eachChar);
            }
        }

        allData.add(thisSet);

        long total = 0;
        for (Set<String> eachSet : allData) {
            total += eachSet.size();
        }

        return total;
    }

    public long execute2() {
        List<Set<String>> allData = new ArrayList<>();

        Set<String> groupSet = null;
        for (String eachLine : inputArray) {

            if (eachLine.trim().length() == 0)
            {
                allData.add(groupSet);
                groupSet = null;
                continue;
            }

            Set<String> thisSet = new HashSet<>();

            char[] chars = eachLine.toCharArray();
             for (char eachChar: chars) {
                 thisSet.add("" + eachChar);
             }

             if (groupSet == null) {
                 groupSet = thisSet;
             }
             else {
                 groupSet.retainAll(thisSet);
             }
        }

        allData.add(groupSet);

        long total = 0;
        for (Set<String> eachSet : allData) {
            total += eachSet.size();
        }

        return total;
    }
}
