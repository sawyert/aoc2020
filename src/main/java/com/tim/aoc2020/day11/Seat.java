package com.tim.aoc2020.day11;

public class Seat extends Location {

    public Seat(int row, int column, Room room) {
        super(row, column, room);
    }

    public String toString() {
        if (occupied) {
            return "#";
        }
        return "L";
    }

    public Seat execute(Room room) {
        Seat newSeat = new Seat(this.row, this.column, room);
        newSeat.setOccupied(this.occupied);

        if (!this.occupied && this.neighboursOccupied() == 0) {
            newSeat.setOccupied(true);
        }

        if (this.occupied && this.neighboursOccupied() >= 4) {
            newSeat.setOccupied(false);
        }

        return newSeat;
    }

    public Seat execute2(Room room) {
        Seat newSeat = new Seat(this.row, this.column, room);
        newSeat.setOccupied(this.occupied);

        if (!this.occupied && this.neighboursOccupied2() == 0) {
            newSeat.setOccupied(true);
        }

        if (this.occupied && this.neighboursOccupied2() >= 5) {
            newSeat.setOccupied(false);
        }

        return newSeat;
    }
}
