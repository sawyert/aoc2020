package com.tim.aoc2020.day9;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day9Example.txt");

        Day9 day = new Day9(input, 5);
        assertEquals(127, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day9.txt");

        Day9 day = new Day9(input, 25);
        System.out.println(day.execute());
    }

    @Test
    void testExampleInputPart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day9Example.txt");

        Day9 day = new Day9(input, 5);
        assertEquals(62, day.execute2(127));
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day9.txt");

        Day9 day = new Day9(input, 25);
        System.out.println(day.execute2(18272118));
    }
}
