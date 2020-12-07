package com.tim.aoc2020.day7;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day7Tests {

    @Test
    void testNodeConstructorWithOneChild() {
        Node node = new Node("striped beige bags contain 5 dull beige bags.");
        assertEquals("striped beige", node.getColour());
        assertEquals(1, node.getChildren().size());
        assertEquals(5, node.getChildren().get(0).count);
        assertEquals("dull beige", node.getChildren().get(0).colour);
    }

    @Test
    void testNodeConstructorWithThreeChildren() {
        Node node = new Node("mirrored turquoise bags contain 2 dim crimson bags, 4 clear crimson bags, 1 dotted blue bag.");
        assertEquals("mirrored turquoise", node.getColour());
        assertEquals(3, node.getChildren().size());

        assertEquals(2, node.getChildren().get(0).count);
        assertEquals("dim crimson", node.getChildren().get(0).colour);

        assertEquals(4, node.getChildren().get(1).count);
        assertEquals("clear crimson", node.getChildren().get(1).colour);

        assertEquals(1, node.getChildren().get(2).count);
        assertEquals("dotted blue", node.getChildren().get(2).colour);
    }

    @Test
    void testParseNoOtherBags() {
        Node node = new Node("faded blue bags contain no other bags.");
        assertEquals("faded blue", node.getColour());
        assertEquals(0, node.getChildren().size());
    }

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day7Example.txt");

        Day7 day = new Day7(testInputArray);
        assertEquals(4, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day7.txt");

        Day7 day = new Day7(testInputArray);
        int result = day.execute();
        assertNotEquals(54, result);
        assertNotEquals(8, result);
        assertNotEquals(17, result);

        System.out.println(result);
    }

    @Test
    void testExampleInputPart2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day7Example.txt");

        Day7 day = new Day7(testInputArray);
        assertEquals(32, day.execute2());
    }

    @Test
    void testExample2InputPart2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day7Example2.txt");

        Day7 day = new Day7(testInputArray);
        assertEquals(126, day.execute2());
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day7.txt");

        Day7 day = new Day7(testInputArray);
        int result = day.execute2();
        System.out.println(result);
    }
}
