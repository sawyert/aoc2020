package com.tim.aoc2020.day12;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day12Part2Tests {


    @Test
    void testExampleInputPart2() {
        String[] example = new String[] {"F10", "N3", "F7", "R90", "F11"};

        Day12Part2 day = new Day12Part2(example);
        assertEquals(286, day.execute());
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day12.txt");

        Day12Part2 day = new Day12Part2(input);
        long result = day.execute();
        assertNotEquals(33947, result);
        assertNotEquals(37689, result);
        assertNotEquals(59813, result);
        assertNotEquals(59479, result);
        assertNotEquals(168187, result);
        assertNotEquals(281945, result);
        System.out.println(result);
    }

    @Test
    void testMoveWayPointNorthCommandInputPart2() {
        Day12Part2 day = new Day12Part2(new String[] {"N10"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(0, day.getRow());
        assertEquals(10, day.getWayPointOffsetColumn());
        assertEquals(11, day.getWayPointOffsetRow());
        assertEquals(0, result);
    }

    @Test
    void testMoveWayPointEastCommandInputPart2() {
        Day12Part2 day = new Day12Part2(new String[] {"E7"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(0, day.getRow());
        assertEquals(17, day.getWayPointOffsetColumn());
        assertEquals(1, day.getWayPointOffsetRow());
        assertEquals(0, result);
    }

    @Test
    void testMoveWayPointSouthCommandInputPart2() {
        Day12Part2 day = new Day12Part2(new String[] {"S10"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(0, day.getRow());
        assertEquals(10, day.getWayPointOffsetColumn());
        assertEquals(-9, day.getWayPointOffsetRow());
        assertEquals(0, result);
    }

    @Test
    void testMoveWayPointWestCommandInputPart2() {
        Day12Part2 day = new Day12Part2(new String[] {"W7"});
        long result = day.execute();
        assertEquals(0, day.getColumn());
        assertEquals(0, day.getRow());
        assertEquals(3, day.getWayPointOffsetColumn());
        assertEquals(1, day.getWayPointOffsetRow());
        assertEquals(0, result);
    }

    @Test
    void testMoveToWayPointCommandInputPart2() {
        Day12Part2 day = new Day12Part2(new String[] {"F1"});
        long result = day.execute();
        assertEquals(10, day.getWayPointOffsetColumn());
        assertEquals(1, day.getWayPointOffsetRow());
        assertEquals(10, day.getColumn());
        assertEquals(1, day.getRow());
        assertEquals(11, result);
    }

    @Test
    void testMoveForward() {
        Day12Part2 day = new Day12Part2(new String[] {"F1"});
        long result = day.execute();
        assertEquals(10, day.getWayPointOffsetColumn());
        assertEquals(1, day.getWayPointOffsetRow());
        assertEquals(10, day.getColumn());
        assertEquals(1, day.getRow());
        assertEquals(11, result);
    }

    @Test
    void testMoveForwardTenTimes() {
        Day12Part2 day = new Day12Part2(new String[] {"F10"});
        long result = day.execute();
        assertEquals(10, day.getWayPointOffsetColumn());
        assertEquals(1, day.getWayPointOffsetRow());
        assertEquals(100, day.getColumn());
        assertEquals(10, day.getRow());
        assertEquals(110, result);
    }

    @Test
    void testMoveSouthTenTimes() {
        Day12Part2 day = new Day12Part2(new String[] {"R90", "F10"});
        long result = day.execute();
        assertEquals(1, day.getWayPointOffsetColumn());
        assertEquals(-10, day.getWayPointOffsetRow());
        assertEquals(10, day.getColumn());
        assertEquals(-100, day.getRow());
        assertEquals(110, result);
    }

    @Test
    void testExampleInput1() {
        String[] example = new String[] {"F10", "N3", "F7", "R90"};

        Day12Part2 day = new Day12Part2(example);
        long result = day.execute();
        assertEquals(4, day.getWayPointOffsetColumn());
        assertEquals(-10, day.getWayPointOffsetRow());
        assertEquals(170, day.getColumn());
        assertEquals(38, day.getRow());
    }

    @Test
    void testExampleInput2() {
        String[] example = new String[] {"F10", "N3", "F7", "R90", "F1"};

        Day12Part2 day = new Day12Part2(example);
        long result = day.execute();
        assertEquals(4, day.getWayPointOffsetColumn());
        assertEquals(-10, day.getWayPointOffsetRow());
        assertEquals(170 + 4, day.getColumn());
        assertEquals(38 - 10, day.getRow());
    }

    @Test
    void testExampleInput3() {
        String[] example = new String[] {"F10", "N3", "F7", "R90", "F11"};

        Day12Part2 day = new Day12Part2(example);
        long result = day.execute();
        assertEquals(4, day.getWayPointOffsetColumn());
        assertEquals(-10, day.getWayPointOffsetRow());
        assertEquals(214, day.getColumn());
        assertEquals(-72, day.getRow());
    }


}
