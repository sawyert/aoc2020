package com.tim.aoc2020.day2;

import com.tim.aco2020.day1.Day1;
import com.tim.aco2020.day2.Day2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2Tests {

    @Test
    void testValidInputWorks() {
        String[] testInput = new String[] {"1-3 a: abcde"};

        Day2 day = new Day2(testInput);
        assertEquals(1, day.execute());
    }

    @Test
    void testInvalidInputFails() {
        String[] testInput = new String[] {"1-3 a: bcde"};

        Day2 day = new Day2(testInput);
        assertEquals(0, day.execute());
    }

    @Test
    void testExampleWorks() {

        String[] testInput = new String[] {"1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc"};

        Day2 day = new Day2(testInput);
        assertEquals(2, day.execute());
    }

    @Test
    void calculateRealAnswer() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("Day2.txt");
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);

        Day2 day = new Day2(testInputArray);
        System.out.println(day.execute());
    }
}
