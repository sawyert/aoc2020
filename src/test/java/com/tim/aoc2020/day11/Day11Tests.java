package com.tim.aoc2020.day11;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11Tests {

    @Test
    void testExample() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day11Example.txt");

        Day11 day = new Day11(input);
        int seatsOccupied = day.execute();
        assertEquals(37, seatsOccupied);
    }

    @Test
    void testPuzzlePart1() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day11.txt");

        Day11 day = new Day11(input);
        int seatsOccupied = day.execute();
        System.out.println(seatsOccupied);
    }

    @Test
    void testExamplePart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day11Example.txt");

        Day11 day = new Day11(input);
        int seatsOccupied = day.execute2();
        assertEquals(26, seatsOccupied);
    }

    @Test
    void testPuzzlePart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day11.txt");

        Day11 day = new Day11(input);
        int seatsOccupied = day.execute2();
        System.out.println(seatsOccupied);
    }

}
