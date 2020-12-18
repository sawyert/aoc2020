package com.tim.aoc2020.day17;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day17Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day17Example.txt");

        Day17 day = new Day17(input);
        assertEquals(112, day.execute(6));
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day17.txt");

        Day17 day = new Day17(input);
        System.out.println(day.execute(6));
    }

    @Test
    void testExampleInputPart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day17Example.txt");

        Day17Part2 day = new Day17Part2(input);
        assertEquals(848, day.execute(6));
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day17.txt");

        Day17Part2 day = new Day17Part2(input);
        System.out.println(day.execute(6));
    }

}
