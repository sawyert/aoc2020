package com.tim.aoc2020.day12;

public class Day12Part2 {
    private String[] input;

    public long getRow() {
        return row;
    }

    public long getColumn() {
        return column;
    }

    public long getWayPointOffsetRow() {
        return wayPointOffsetRow;
    }

    public long getWayPointOffsetColumn() {
        return wayPointOffsetColumn;
    }

    private long row = 0;
    private long column = 0;

    private long wayPointOffsetRow = 1;
    private long wayPointOffsetColumn = 10;


    public Day12Part2(String[] input) {
        this.input = input;
    }

    public void executeInstruction(String instruction) {
        char letter = instruction.charAt(0);
        int count = Integer.parseInt(instruction.substring(1));

        if (letter == 'F') {
            for (int i=0;i<count;i++) {
                this.row += this.wayPointOffsetRow;
                this.column += this.wayPointOffsetColumn;
            }
        }

        switch(letter) {
            case 'N':
                this.wayPointOffsetRow += count;
                break;
            case 'E':
                this.wayPointOffsetColumn += count;
                break;
            case 'S':
                this.wayPointOffsetRow -= count;
                break;
            case 'W':
                this.wayPointOffsetColumn -= count;
                break;
            case 'L':
                this.turn("L", count);
                break;
            case 'R':
                this.turn("R", count);
                break;
        }
    }

    private void turn(String leftRight, int count) {
        int multiple = count / 90;
        if (leftRight.equals("L")) {
            multiple = multiple * 3;
        }
        for (int i=0;i<multiple;i++) {
            long newOffsetColumn = wayPointOffsetRow;
            long newOffsetRow = wayPointOffsetColumn * -1;

            this.wayPointOffsetRow = newOffsetRow;
            this.wayPointOffsetColumn = newOffsetColumn;
        }
    }



    public long execute() {
        for (String line : input) {
            this.executeInstruction(line);
        }

        long endRow = this.row;
        if (endRow < 0) {
            endRow = endRow * -1;
        }
        long endColumn = this.column;
        if (endColumn < 0) {
            endColumn = endColumn * -1;
        }
        return endRow + endColumn;
    }
}
