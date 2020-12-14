package com.tim.aoc2020.day14;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Part2Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day14ExamplePart2.txt");

        Day14Part2 day = new Day14Part2(input);
        assertEquals(208, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day14.txt");

        Day14Part2 day = new Day14Part2(input);
        System.out.println(day.execute());
    }
}
