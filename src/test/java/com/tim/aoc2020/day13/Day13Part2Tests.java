package com.tim.aoc2020.day13;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Part2Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day13Example.txt");

        Day13Part2 day = new Day13Part2(input);
        assertEquals(1068781, day.execute());
    }

    @Test
    void testExampleInput1() {
        String[] input = new String[] {"0", "17,x,13,19"};
        Day13Part2 day = new Day13Part2(input);
        assertEquals(3417, day.execute());
    }

    @Test
    void testExampleInput2()  {
        String[] input = new String[] {"0", "67,7,59,61"};
        Day13Part2 day = new Day13Part2(input);
        assertEquals(754018, day.execute());
    }

    @Test
    void testExampleInput3()  {
        String[] input = new String[] {"0", "67,7,x,59,61"};
        Day13Part2 day = new Day13Part2(input);
        assertEquals(1261476, day.execute());
    }

    @Test
    void testExampleInput4()  {
        String[] input = new String[] {"0", "1789,37,47,1889"};
        Day13Part2 day = new Day13Part2(input);
        assertEquals(1202161486, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] input = FileReader.read("Day13.txt");

        Day13Part2 day = new Day13Part2(input);
        System.out.println(day.execute());
    }
}
