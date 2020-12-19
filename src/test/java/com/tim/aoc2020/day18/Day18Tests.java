package com.tim.aoc2020.day18;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day18Tests {


    @Test
    void testExample1() {
        String[] example = new String[] {"1 + 2 * 3 + 4 * 5 + 6"};

        Day18 day = new Day18(example);
        assertEquals(71, day.execute());
    }

    @Test
    void testExample2() {
        String[] example = new String[] {"2 * 3 + (4 * 5)"};

        Day18 day = new Day18(example);
        assertEquals(26, day.execute());
    }

    @Test
    void testExample3() {
        String[] example = new String[] {"5 + (8 * 3 + 9 + 3 * 4 * 3)"};

        Day18 day = new Day18(example);
        assertEquals(437, day.execute());
    }

    @Test
    void testExample4() {
        String[] example = new String[] {"5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"};

        Day18 day = new Day18(example);
        assertEquals(12240, day.execute());
    }

    @Test
    void testExample5() {
        String[] example = new String[] {"((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"};

        Day18 day = new Day18(example);
        assertEquals(13632, day.execute());
    }

    @Test
    void testExample6() {
        String[] example = new String[] {"6 * (2 + 4 * (3 + 7 * 8 + 4) * 8 + 3 + (9 + 8 + 4 + 9)) * 8 + ((2 * 5 * 9 + 7 + 4 * 3) + (8 + 3 + 7) + (7 + 2) * 8 * 8 + 9)"};

        Day18 day = new Day18(example);
        assertEquals(216249, day.execute());
    }



    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day18.txt");

        Day18 day = new Day18(input);
        long result = day.execute();
        assertNotEquals(10329548556L, result);
        System.out.println(result);

    }
}
