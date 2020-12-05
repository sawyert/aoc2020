package com.tim.aoc2020.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

    private String[] inputArray;
    private List<Seat> seats = new ArrayList<>();

    public Day5(String[] testInputArray) {
        this.inputArray = testInputArray;
    }

    public long execute() {
        long highestId = 0;
        for (String eachSeat : inputArray) {
            Seat seat = new Seat(eachSeat);
            long id = seat.getId();

            if (id > highestId) {
                highestId = id;
            }
        }

        return highestId;
    }

    public long execute2() {
        long maxId = 0;
        long minId = 999999999;
        for (String eachSeat : inputArray) {
            Seat seat = new Seat(eachSeat);
            this.seats.add(seat);

            if (seat.getId() < minId) {
                minId = seat.getId();
            }

            if (seat.getId() > maxId) {
                maxId = seat.getId();
            }
        }

        this.seats.sort(Comparator.comparing(o -> o.getId()));

        for (int i = 1; i < seats.size() - 1; i++) {
            long thisSeat = seats.get(i).getId();
            long lastSeat = seats.get(i-1).getId();

            if (thisSeat - 1 != lastSeat) {
                return thisSeat - 1;
            }
        }

        return 0;
    }
}
