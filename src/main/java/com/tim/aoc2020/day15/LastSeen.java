package com.tim.aoc2020.day15;

import java.util.HashMap;
import java.util.Map;

public class LastSeen {
    private Map<Integer, LastSeenNumber> lastSeenNumberMap = new HashMap<>();

    public void seen(int number, int loopPosition) {
        int arrayPosition = loopPosition + 1;

        LastSeenNumber existingRecord = lastSeenNumberMap.get(number);
        if (existingRecord == null) {
            existingRecord = new LastSeenNumber();
            existingRecord.lastSeen(arrayPosition);
            lastSeenNumberMap.put(number, existingRecord);
        } else {
            existingRecord.lastSeen(arrayPosition);
        }
    }

    public Integer lastSeenBefore(Integer number, int loopPosition) {
        LastSeenNumber existingRecord = lastSeenNumberMap.get(number);
        if (existingRecord == null) {
            return null;
        } else {
            return existingRecord.lastSeenBefore(loopPosition);
        }
    }
}
