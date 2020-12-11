package com.tim.aoc2020.day11;

public class Floor extends Location {

    public Floor(int row, int column, Room room) {
        super(row, column, room);
    }

    public String toString() {
        return ".";
    }

    public Floor execute(Room room) {
        return new Floor(this.row, this.column, room);
    }

    public Floor execute2(Room room) {
        return new Floor(this.row, this.column, room);
    }

    public boolean isOccupied() {
        return false;
    }
}
