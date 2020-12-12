package com.tim.aoc2020.day11;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private Location[][] locations = new Location[100][100];

    public Room(String[] input) {
        int row = 0;
        for (String eachLine : input) {
            for (int column = 0; column < eachLine.length(); column++) {
                char locationChar = eachLine.charAt(column);
                switch (locationChar) {
                    case '.':
                        Location floorLocation = new Floor(row, column, this);
                        locations[row][column] = floorLocation;
                        break;
                    case 'L':
                        Location seatLocation = new Seat(row, column, this);
                        locations[row][column] = seatLocation;
                        break;
                    default:
                        throw new UnsupportedOperationException("Unknown map character: [" + locationChar + "]");
                }
            }

            row++;
        }

        relink();
    }

    public void relink()
    {
        for (int linkRow=0; linkRow<100;linkRow++){
            for (int linkColumn=0;linkColumn<100; linkColumn++) {
                Location topLeft = null;
                Location top = null;
                Location topRight = null;
                Location right = null;
                Location bottomRight = null;
                Location bottom = null;
                Location bottomLeft = null;
                Location left = null;

                if (linkRow > 0 && linkColumn > 0) topLeft = locations[linkRow-1][linkColumn-1];
                if (linkRow > 0) top = locations[linkRow-1][linkColumn];
                if (linkRow > 0 && linkColumn < 99) topRight = locations[linkRow-1][linkColumn+1];
                if (linkColumn < 99) right = locations[linkRow][linkColumn+1];
                if (linkRow < 99 && linkColumn < 99) bottomRight = locations[linkRow+1][linkColumn+1];
                if (linkRow < 99) bottom = locations[linkRow+1][linkColumn];
                if (linkRow < 99 && linkColumn > 0) bottomLeft = locations[linkRow+1][linkColumn-1];
                if (linkColumn > 0) left = locations[linkRow][linkColumn-1];

                Location location = locations[linkRow][linkColumn];
                if (location != null) {

                    location.setTopLeft(topLeft);
                    location.setTop(top);
                    location.setTopRight(topRight);
                    location.setRight(right);
                    location.setBottomRight(bottomRight);
                    location.setBottom(bottom);
                    location.setBottomLeft(bottomLeft);
                    location.setLeft(left);
                }
            }
        }
    }

    public Room() {

    }

    public void printRoom() {
        if (false) {
            for (int row = 0; row < 100; row++) {
                StringBuilder line = new StringBuilder();
                for (int column = 0; column < 100; column++) {
                    Location location = locations[row][column];
                    if (location != null) {
                        line.append(location);
                    }
                }
                if (line.toString().trim().length() > 0) {
                    System.out.println(line);
                }
            }
        }
    }

    public int execute(Room oldRoomState) {
        int changes = 0;
        for (int row=0; row<100;row++) {
            for (int column = 0; column < 100; column++) {
                Location existingLocation = oldRoomState.getLocation(row, column);
                if (existingLocation != null) {
                    Location newLocation = existingLocation.execute(this);
                    this.locations[row][column] = newLocation;
                    if (existingLocation.isOccupied() != newLocation.isOccupied()) {
                        changes++;
                    }
                }
            }
        }
        this.relink();

        return changes;
    }

    private Location getLocation(int row, int column) {
        return locations[row][column];
    }

    public int seatsOccupied() {
        int occupiedSeats = 0;
        for (int row=0; row<100;row++) {
            for (int column = 0; column < 100; column++) {
                Location location = this.locations[row][column];
                if (location != null) {
                    if (location.isOccupied()) occupiedSeats++;
                }
            }
        }
        return occupiedSeats;
    }

    public int execute2(Room oldRoomState) {
        int changes = 0;
        for (int row=0; row<100;row++) {
            for (int column = 0; column < 100; column++) {
                Location existingLocation = oldRoomState.getLocation(row, column);
                if (existingLocation != null) {
                    Location newLocation = existingLocation.execute2(this);
                    this.locations[row][column] = newLocation;
                    if (existingLocation.isOccupied() != newLocation.isOccupied()) {
                        changes++;
                    }
                }
            }
        }
        this.relink();

        return changes;
    }
}
