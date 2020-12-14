package com.tim.aoc2020.day14;

import com.tim.aoc2020.FileReader;
import com.tim.aoc2020.day12.Day12;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day14Example.txt");

        Day14 day = new Day14(input);
        assertEquals(165, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day14.txt");

        Day14 day = new Day14(input);
        System.out.println(day.execute());
    }
}
