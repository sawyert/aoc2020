package com.tim.aoc2020.day3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day3Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("Day3Example.txt");
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);

        Day3 day = new Day3(testInputArray);
        assertEquals(7, day.execute(3, 1));
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("Day3.txt");
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);

        Day3 day = new Day3(testInputArray);
        //System.out.println(day.execute(3, 1));
    }

    @Test
    void testExampleInputPart2() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("Day3Example.txt");
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);

        Day3 day = new Day3(testInputArray);
        assertEquals(336, day.executePart2());
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("Day3.txt");
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);

        Day3 day = new Day3(testInputArray);
        long result = day.executePart2();
        assertNotEquals(1441507470, result);
        System.out.println(result);
    }

}
