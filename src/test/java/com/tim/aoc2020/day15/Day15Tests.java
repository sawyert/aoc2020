package com.tim.aoc2020.day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day15Tests {

    @Test
    void testExampleInput1() {
        Day15 day = new Day15 ("0,3,6", 2020);
        assertEquals(436, day.execute());
    }

    @Test
    void testExampleInput2() {
        Day15 day = new Day15 ("1,3,2", 2020);
        assertEquals(1, day.execute());
    }

    @Test
    void testExampleInput3() {
        Day15 day = new Day15 ("2,1,3", 2020);
        assertEquals(10, day.execute());
    }

    @Test
    void testExampleInput4() {
        Day15 day = new Day15 ("1,2,3", 2020);
        assertEquals(27, day.execute());
    }

    @Test
    void testExampleInput5() {
        Day15 day = new Day15 ("2,3,1", 2020);
        assertEquals(78, day.execute());
    }

    @Test
    void testExampleInput6() {
        Day15 day = new Day15 ("3,2,1", 2020);
        assertEquals(438, day.execute());
    }

    @Test
    void testExampleInput7() {
        Day15 day = new Day15 ("3,1,2", 2020);
        assertEquals(1836, day.execute());
    }

    @Test
    void testPuzzleInput() {
        Day15 day = new Day15 ("14,3,1,0,9,5", 2020);
       System.out.println(day.execute());
    }

    @Test
    void testPuzzleInputPart2() {
        Day15 day = new Day15 ("14,3,1,0,9,5", 30000000);
        System.out.println(day.execute());
    }
}
