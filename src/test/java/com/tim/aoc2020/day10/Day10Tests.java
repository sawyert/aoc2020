package com.tim.aoc2020.day10;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day10Tests {

    @Test
    void testExample1() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day10Example1.txt");

        Day10 day = new Day10(input);
        assertEquals(7 * 5, day.execute());
    }

    @Test
    void testExample2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day10Example2.txt");

        Day10 day = new Day10(input);
        assertEquals(22 * 10, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day10.txt");

        Day10 day = new Day10(input);
        System.out.println(day.execute());
    }

    @Test
    void testPart2() {
        Day10 day = new Day10(new String[] { "3" });
        assertEquals(1, day.execute2());

        day = new Day10(new String[] { "3", "6" });
        assertEquals(1, day.execute2());

        day = new Day10(new String[] { "3", "4", "6"});
        assertEquals(1, day.execute2());

        day = new Day10(new String[] { "3", "4", "5", "6"});
        assertEquals(4, day.execute2());
    }

    @Test
    void testExample1Part2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day10Example1.txt");

        Day10 day = new Day10(input);
        assertEquals(8, day.execute2());
    }

    @Test
    void testExample2Part2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day10Example2.txt");

        Day10 day = new Day10(input);
        assertEquals(19208, day.execute2());
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day10.txt");

        Day10 day = new Day10(input);
        long result = day.execute2();
        assertNotEquals(570425344, result); // too low
        System.out.println(result);
    }


}
