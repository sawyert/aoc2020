package com.tim.aoc2020.day13;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day13Example.txt");

        Day13 day = new Day13(input);
        assertEquals(295, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day13.txt");

        Day13 day = new Day13(input);
        System.out.println(day.execute());
    }
}
