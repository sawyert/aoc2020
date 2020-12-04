package com.tim.aoc2020.day4;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Tests {

    @Test
    void testPart1ExampleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day4Example.txt");

        Day4 day = new Day4(testInputArray);
        assertEquals(2, day.execute());
    }

    @Test
    void testPart1PuzzleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day4.txt");

        Day4 day = new Day4(testInputArray);
        System.out.println(day.execute());
    }

    @Test
    void testPart2ExampleInput1() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day4_2_Example1.txt");

        Day4 day = new Day4(testInputArray);
        assertEquals(0, day.execute2());
    }

    @Test
    void testPart2ExampleInput2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day4_2_Example2.txt");

        Day4 day = new Day4(testInputArray);
        assertEquals(4, day.execute2());
    }

    @Test
    void testPart2PuzzleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day4.txt");

        Day4 day = new Day4(testInputArray);
        System.out.println(day.execute2());
    }
}
