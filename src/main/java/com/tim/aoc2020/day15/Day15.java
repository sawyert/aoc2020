package com.tim.aoc2020.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day15 {

    private String[] inputSplit;
    private long max;

    public Day15(String input, long max) {
        this.inputSplit = input.split(",");
        this.max = max;
    }

    public long execute() {
        LastSeen lastSeen = new LastSeen();
        Integer lastNumber = null;
        for (int i=0; i<max; i++) {
            if (i < inputSplit.length) {
                lastSeen.seen(Integer.parseInt(inputSplit[i]), i);
                lastNumber = Integer.parseInt(inputSplit[i]);
                continue;
            }


            Integer lastTimeSeen = lastSeen.lastSeenBefore(lastNumber, i);
            if (lastTimeSeen == null || lastTimeSeen == i) {
                lastSeen.seen(0, i);
                lastNumber = 0;
                continue;
            }


            int foundPosition = lastSeen.lastSeenBefore(lastNumber, i);
            int newValue = i - foundPosition;
            lastSeen.seen(newValue, i);
            lastNumber = newValue;
        }

        return lastNumber;
    }

}
