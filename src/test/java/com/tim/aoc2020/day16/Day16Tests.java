package com.tim.aoc2020.day16;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day16Tests {

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] rules = FileReader.read("Day16_example_rules.txt");
        String[] tickets = FileReader.read("Day16_example_tickets.txt");

        Day16 day = new Day16(rules, tickets);
        assertEquals(71, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] rules = FileReader.read("Day16_rules.txt");
        String[] tickets = FileReader.read("Day16_tickets.txt");

        Day16 day = new Day16(rules, tickets);
        System.out.println(day.execute());
    }

    @Test
    void testExampleInputPart2() throws IOException, URISyntaxException {
        String[] rules = FileReader.read("Day16_example_rules2.txt");
        String[] tickets = FileReader.read("Day16_example_tickets2.txt");

        Day16 day = new Day16(rules, tickets);
        System.out.println(day.execute2("11,12,13"));
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] rules = FileReader.read("Day16_rules.txt");
        String[] tickets = FileReader.read("Day16_tickets.txt");

        Day16 day = new Day16(rules, tickets);
        System.out.println(day.execute2("127,89,149,113,181,131,53,199,103,107,97,179,109,193,151,83,197,101,211,191"));
    }
}
