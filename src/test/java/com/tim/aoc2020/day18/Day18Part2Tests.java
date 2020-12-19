package com.tim.aoc2020.day18;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day18Part2Tests {


    @Test
    void testExample1() {
        String[] example = new String[] {"1 + 2 * 3 + 4 * 5 + 6"};

        Day18Part2 day = new Day18Part2(example);
        assertEquals(231, day.execute());
    }

    @Test
    void testExample2() {
        String[] example = new String[] {"2 * 3 + (4 * 5)"};

        Day18Part2 day = new Day18Part2(example);
        assertEquals(46, day.execute());
    }

    @Test
    void testExample3() {
        String[] example = new String[] {"5 + (8 * 3 + 9 + 3 * 4 * 3)"};

        Day18Part2 day = new Day18Part2(example);
        assertEquals(1445, day.execute());
    }

    @Test
    void testExample4() {
        String[] example = new String[] {"5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"};

        Day18Part2 day = new Day18Part2(example);
        assertEquals(669060, day.execute());
    }

    @Test
    void testExample5() {
        String[] example = new String[] {"((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"};

        Day18Part2 day = new Day18Part2(example);
        assertEquals(23340, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day18.txt");

        Day18Part2 day = new Day18Part2(input);
        long result = day.execute();
        System.out.println(result);

    }
}
