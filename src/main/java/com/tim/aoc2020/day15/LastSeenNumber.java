package com.tim.aoc2020.day15;

import java.util.LinkedList;
import java.util.List;

public class LastSeenNumber {
    List<Integer> lastSeen = new LinkedList<>();

    public void lastSeen(int arrayPosition) {
        this.lastSeen.add(arrayPosition);
        if (this.lastSeen.size() > 2) {
            lastSeen.remove(0);
        }
    }

    public Integer lastSeenBefore(int arrayPosition) {
        int lastValue = this.lastSeen.get(this.lastSeen.size() - 1);
        if (lastValue == arrayPosition) {
            if (this.lastSeen.size() == 1) {
                return null;
            }

            lastValue = this.lastSeen.get(this.lastSeen.size() - 2);
        }
        return lastValue;
    }
}
