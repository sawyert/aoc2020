package com.tim.aoc2020.day5;

import com.tim.aoc2020.FileReader;
import com.tim.aoc2020.day4.Day4;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5Tests {

    @Test
    void testExampleInput1()  {
        Seat seat = new Seat("FBFBBFFRLR");
        assertEquals(44, seat.getRow());
        assertEquals(5, seat.getColumn());
        assertEquals(357, seat.getId());
    }

    @Test
    void testExampleInput2()  {
        Seat seat = new Seat("BFFFBBFRRR");
        assertEquals(70, seat.getRow());
        assertEquals(7, seat.getColumn());
        assertEquals(567, seat.getId());
    }

    @Test
    void testExampleInput3()  {
        Seat seat = new Seat("FFFBBBFRRR");
        assertEquals(14, seat.getRow());
        assertEquals(7, seat.getColumn());
        assertEquals(119, seat.getId());
    }

    @Test
    void testExampleInput4() {
        Seat seat = new Seat("BBFFBBFRLL");
        assertEquals(102, seat.getRow());
        assertEquals(4, seat.getColumn());
        assertEquals(820, seat.getId());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day5.txt");
        Day5 day = new Day5(testInputArray);
        System.out.println(day.execute());
    }

    @Test
    void testPuzzleInput2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day5.txt");
        Day5 day = new Day5(testInputArray);
        System.out.println(day.execute2());
    }

}
