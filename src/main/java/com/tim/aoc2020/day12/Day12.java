package com.tim.aoc2020.day12;

public class Day12 {
    private String[] input;
    private Directions direction = Directions.EAST;

    public long getRow() {
        return row;
    }

    public long getColumn() {
        return column;
    }

    private long row = 0;
    private long column = 0;


    public Day12(String[] input) {
        this.input = input;
    }

    public void executeInstruction(String instruction) {
        char letter = instruction.charAt(0);
        int count = Integer.parseInt(instruction.substring(1));

        if (letter == 'F') {
            switch (this.direction) {
                case NORTH:
                    letter = 'N';
                    break;
                case EAST:
                    letter = 'E';
                    break;
                case SOUTH:
                    letter = 'S';
                    break;
                case WEST:
                    letter = 'W';
            }
        }

        switch(letter) {
            case 'N':
                this.row += count;
                break;
            case 'E':
                this.column += count;
                break;
            case 'S':
                this.row -= count;
                break;
            case 'W':
                this.column -= count;
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
        for (int i=0;i<multiple;i++){
            switch (direction) {
                case NORTH:
                    if ("R".equals(leftRight)) {
                        direction = Directions.EAST;
                    }
                    else
                    {
                        direction = Directions.WEST;
                    }
                    break;
                case EAST:
                    if ("R".equals(leftRight)) {
                        direction = Directions.SOUTH;
                    }
                    else
                    {
                        direction = Directions.NORTH;
                    }
                    break;
                case SOUTH:
                    if ("R".equals(leftRight)) {
                        direction = Directions.WEST;
                    }
                    else
                    {
                        direction = Directions.EAST;
                    }
                    break;
                case WEST:
                    if ("R".equals(leftRight)) {
                        direction = Directions.NORTH;
                    }
                    else
                    {
                        direction = Directions.SOUTH;
                    }
                    break;
            }
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
