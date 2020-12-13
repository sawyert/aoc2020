package com.tim.aoc2020.day13;

import java.util.ArrayList;
import java.util.List;

public class Day13 {
    private final int targetTime;
    private final List<Integer> busTimes = new ArrayList<>();

    public Day13(String[] input) {
        this.targetTime = Integer.parseInt(input[0]);
        String[] busTimesString = input[1].split(",");
        for (String eachTime : busTimesString) {
            if (!eachTime.equals("x")) {
                this.busTimes.add(Integer.parseInt(eachTime));
            }
        }
    }

    public long execute() {
        int lowestTimeAfterTarget = 9999999;
        long answer = 0;
        for (Integer eachBusTime : this.busTimes) {
            int lastBusBeforeTarget = (this.targetTime / eachBusTime) * eachBusTime;
            int busAfterTarget = lastBusBeforeTarget + eachBusTime;
            int timeAfterTarget = busAfterTarget - this.targetTime ;
            if (timeAfterTarget < lowestTimeAfterTarget) {
               lowestTimeAfterTarget = timeAfterTarget;
               answer = eachBusTime * timeAfterTarget;
           }
        }

        return answer;
    }
}
