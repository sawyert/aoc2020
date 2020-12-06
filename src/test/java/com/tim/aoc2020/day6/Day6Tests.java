package com.tim.aoc2020.day6;

import com.tim.aoc2020.FileReader;
import com.tim.aoc2020.day5.Day5;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day6Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day6Example.txt");
        Day6 day = new Day6(testInputArray);
        assertEquals(11, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day6.txt");
        Day6 day = new Day6(testInputArray);
        System.out.println(day.execute());
    }

    @Test
    void testExampleInputPart2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day6Example.txt");
        Day6 day = new Day6(testInputArray);
        assertEquals(6, day.execute2());
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day6.txt");
        Day6 day = new Day6(testInputArray);
        System.out.println(day.execute2());
    }
}
