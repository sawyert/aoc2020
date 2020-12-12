package com.tim.aoc2020.day12;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day12Tests {

    @Test
    void testForwardCommandInput() {
        Day12 day = new Day12(new String[] {"F10"});
        long result = day.execute();
        assertEquals(10, day.getColumn());
        assertEquals(0, day.getRow());
        assertEquals(10, result);
    }

    @Test
    void testTurnLeftCommandInput() {
        Day12 day = new Day12(new String[] {"L90", "F5"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(5, day.getRow());
        assertEquals(5, result);
    }

    @Test
    void testTurnRightCommandInput() {
        Day12 day = new Day12(new String[] {"R90", "F5"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(-5, day.getRow());
        assertEquals(5, result);
    }

    @Test
    void testTurnRightMoreCommandInput() {
        Day12 day = new Day12(new String[] {"R270", "F5"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(5, day.getRow());
        assertEquals(5, result);
    }

    @Test
    void testMoveNorthCommandInput() {
        Day12 day = new Day12(new String[] {"N10"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(10, day.getRow());
        assertEquals(10, result);
    }

    @Test
    void testMoveEastCommandInput() {
        Day12 day = new Day12(new String[] {"E10"});
        long result = day.execute();
        assertEquals(10, day.getColumn());
        assertEquals(0, day.getRow());
        assertEquals(10, result);
    }

    @Test
    void testMoveSouthCommandInput() {
        Day12 day = new Day12(new String[] {"S10"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(-10, day.getRow());
        assertEquals(10, result);
    }

    @Test
    void testMoveWestCommandInput() {
        Day12 day = new Day12(new String[] {"W10"});
        long result = day.execute();
        assertEquals(-10, day.getColumn());
        assertEquals(0, day.getRow());
        assertEquals(10, result);
    }

    @Test
    void testExampleInput() {
        String[] example = new String[] {"F10", "N3", "F7", "R90", "F11"};

        Day12 day = new Day12(example);
        assertEquals(25, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day12.txt");

        Day12 day = new Day12(input);
       System.out.println(day.execute());
    }
}
