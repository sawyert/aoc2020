package com.tim.aoc2020.day1;

import com.tim.aco2020.day1.Day1;
import com.tim.aco2020.day1.Day1_1;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1_1Tests {

    @Test
    void testBasicInputWorks() {
        String[] testInput = new String[] {"1","2","3","4","5","5","2010"};

        Day1_1 day1 = new Day1_1(testInput);
        assertEquals(50250, day1.execute());
    }

    @Test
    void testExampleWorks() {
        String[] testInput = new String[] {"1721", "979", "366", "299", "675", "1456"};

        Day1_1 day1 = new Day1_1(testInput);
        assertEquals(241861950, day1.execute());
    }

    @Test
    void calculateRealAnswer() throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource("Day1.txt");
        Path filePath = Paths.get(url.toURI());
        List<String> testInput = Files.readAllLines(filePath);
        String[] testInputArray = testInput.toArray(new String[0]);

        Day1_1 day1 = new Day1_1(testInputArray);
        System.out.println(day1.execute());
    }
}
