package com.tim.aoc2020.day5;

public class Seat {

    private int row;
    private int column;

    public Seat(String seatSpec) {
        String rowSpec = seatSpec.substring(0, 7);
        String columnSpec = seatSpec.substring(7);

        if (rowSpec.length() != 7) { throw new UnsupportedOperationException(); }
        if (columnSpec.length() != 3) { throw new UnsupportedOperationException(); }

        String rowSpecBinary = rowSpec.replace('F', '0').replace('B', '1');
        String columnSpecBinary = columnSpec.replace('L', '0').replace('R', '1');

        this.row = Integer.parseInt(rowSpecBinary, 2);
        this.column = Integer.parseInt(columnSpecBinary, 2);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public long getId() {
        return (row * 8) + column;
    }
}
