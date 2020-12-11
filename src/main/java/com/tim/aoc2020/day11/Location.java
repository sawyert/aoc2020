package com.tim.aoc2020.day11;

public abstract class Location {
    protected Location topLeft;
    protected Location top;
    protected Location topRight;
    protected Location right;
    protected Location bottomRight;
    protected Location bottom;
    protected Location bottomLeft;
    protected Location left;
    protected boolean occupied;
    protected int row;
    protected int column;
    protected Room room;

    public Location(int row, int column, Room room){
        this.row = row;
        this.column = column;
        this.room = room;
    }

    public void setTopLeft(Location topLeft){
        this.topLeft = topLeft;
    }

    public void setTop(Location top){
        this.top = top;
    }

    public void setTopRight(Location topRight){
        this.topRight = topRight;
    }

    public void setRight(Location right){
        this.right = right;
    }

    public void setBottomRight(Location bottomRight){
        this.bottomRight = bottomRight;
    }

    public void setBottom(Location bottom){
        this.bottom = bottom;
    }

    public void setBottomLeft(Location bottomLeft){
        this.bottomLeft = bottomLeft;
    }

    public void setLeft(Location left){
        this.left = left;
    }

    public abstract Location execute(Room room);
    public abstract Location execute2(Room room);

    public boolean isOccupied() {
        return this.occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    protected int neighboursOccupied() {
        int occupiedCount = 0;
        if (this.bottom != null && this.bottom.isOccupied()) occupiedCount++;
        if (this.bottomRight != null && this.bottomRight.isOccupied()) occupiedCount++;
        if (this.right != null && this.right.isOccupied()) occupiedCount++;
        if (this.topRight != null && this.topRight.isOccupied()) occupiedCount++;
        if (this.top != null && this.top.isOccupied()) occupiedCount++;
        if (this.topLeft != null && this.topLeft.isOccupied()) occupiedCount++;
        if (this.left != null && this.left.isOccupied()) occupiedCount++;
        if (this.bottomLeft != null && this.bottomLeft.isOccupied()) occupiedCount++;

        return occupiedCount;
    }

    protected int neighboursOccupied2() {
        int occupiedCount = 0;
        // find first seat in a given direction

        if (this.bottom != null && this.bottom.isFirstSeatOccupied(Direction.BOTTOM)) occupiedCount++;
        if (this.bottomRight != null && this.bottomRight.isFirstSeatOccupied(Direction.BOTTOM_RIGHT)) occupiedCount++;
        if (this.right != null && this.right.isFirstSeatOccupied(Direction.RIGHT)) occupiedCount++;
        if (this.topRight != null && this.topRight.isFirstSeatOccupied(Direction.TOP_RIGHT)) occupiedCount++;
        if (this.top != null && this.top.isFirstSeatOccupied(Direction.TOP)) occupiedCount++;
        if (this.topLeft != null && this.topLeft.isFirstSeatOccupied(Direction.TOP_LEFT)) occupiedCount++;
        if (this.left != null && this.left.isFirstSeatOccupied(Direction.LEFT)) occupiedCount++;
        if (this.bottomLeft != null && this.bottomLeft.isFirstSeatOccupied(Direction.BOTTOM_LEFT)) occupiedCount++;

        return occupiedCount;
    }

    protected boolean isFirstSeatOccupied(Direction direction) {
        Location location = this;

        while (true) {
            if (location == null) return false;
            if (location instanceof Seat) return location.isOccupied();

            switch (direction) {
                case BOTTOM:
                    location = location.bottom;
                    break;
                case BOTTOM_RIGHT:
                    location = location.bottomRight;
                    break;
                case RIGHT:
                    location = location.right;
                    break;
                case TOP_RIGHT:
                    location = location.topRight;
                    break;
                case TOP:
                    location = location.top;
                    break;
                case TOP_LEFT:
                    location = location.topLeft;
                    break;
                case LEFT:
                    location = location.left;
                    break;
                case BOTTOM_LEFT:
                    location = location.bottomLeft;
                    break;
            }
        }




    }
}
