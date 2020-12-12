package com.tim.aoc2020.day11;

public class Day11 {

    private Room room;

    public Day11(String[] input) {
        this.room = new Room(input);
    }

    public int execute() {
        room.printRoom();
        System.out.println();

        Room newRoom = new Room();
        int changes = newRoom.execute(room);

        while (changes > 0) {
            newRoom.printRoom();
            // System.out.println(changes);

            Room anotherRoom = new Room();
            changes = anotherRoom.execute(newRoom);
            newRoom = anotherRoom;
        }

        return newRoom.seatsOccupied();
    }

    public int execute2() {
        Room newRoom = new Room();
        int changes = newRoom.execute2(room);

        while (changes > 0) {
            newRoom.printRoom();
            // System.out.println(changes);

            Room anotherRoom = new Room();
            changes = anotherRoom.execute2(newRoom);
            newRoom = anotherRoom;
        }

        return newRoom.seatsOccupied();
    }
}
