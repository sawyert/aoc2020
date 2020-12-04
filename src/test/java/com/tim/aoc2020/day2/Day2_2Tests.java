package com.tim.aoc2020.day2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2_2Tests {

    @Test
    void testValidInputWorksInPosition1() {
        String[] testInput = new String[] {"1-3 a: abcde"};

        Day2_2 day = new Day2_2(testInput);
        assertEquals(1, day.execute());
    }

    @Test
    void testValidInputWorksInPosition2() {
        String[] testInput = new String[] {"1-3 a: zabcde"};

        Day2_2 day = new Day2_2(testInput);
        assertEquals(0, day.execute());
    }

    @Test
    void testValidInputWorksInPosition3() {
        String[] testInput = new String[] {"1-3 a: zzabcde"};

        Day2_2 day = new Day2_2(testInput);
        assertEquals(1, day.execute());
    }

    @Test
    void testValidInputFailsInPostion4() {
        String[] testInput = new String[] {"1-3 a: zzzabcde"};

        Day2_2 day = new Day2_2(testInput);
        assertEquals(0, day.execute());
    }

    @Test
    void testValidInputFailsIfDuplicate() {
        String[] testInput = new String[] {"1-3 a: aaabcde"};

        Day2_2 day = new Day2_2(testInput);
        assertEquals(0, day.execute());
    }

    @Test
    void testExampleWorks() {

        String[] testInput = new String[] {"1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"};

        Day2_2 day = new Day2_2(testInput);
        assertEquals(1, day.execute());
    }

    @Test
    void calculateRealAnswer() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("Day2.txt");
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);

        Day2_2 day = new Day2_2(testInputArray);
        System.out.println(day.execute());
    }
}
