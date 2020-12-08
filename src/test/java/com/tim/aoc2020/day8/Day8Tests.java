package com.tim.aoc2020.day8;

import com.tim.aoc2020.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day8Tests {

    @Test
    void testAccInstructionParsesSuccessfully() {
        Instruction instr = new Instruction("acc +1");
        assertEquals(InstructionType.ACC, instr.getInstructionType());
        assertEquals(1, instr.getParameter());

        instr = new Instruction("acc -1");
        assertEquals(InstructionType.ACC, instr.getInstructionType());
        assertEquals(-1, instr.getParameter());
    }

    @Test
    void testJmpInstructionParsesSuccessfully() {
        Instruction instr = new Instruction("jmp +6");
        assertEquals(InstructionType.JMP, instr.getInstructionType());
        assertEquals(6, instr.getParameter());

        instr = new Instruction("jmp -54");
        assertEquals(InstructionType.JMP, instr.getInstructionType());
        assertEquals(-54, instr.getParameter());
    }

    @Test
    void testNopInstructionParsesSuccessfully() {
        Instruction instr = new Instruction("nop +2");
        assertEquals(InstructionType.NOP, instr.getInstructionType());
        assertEquals(2, instr.getParameter());

        instr = new Instruction("nop +0");
        assertEquals(InstructionType.NOP, instr.getInstructionType());
        assertEquals(0, instr.getParameter());
    }

    @Test
    void testExampleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day8Example.txt");
        Day8 day = new Day8(testInputArray);
        assertEquals(5, day.execute());
    }

    @Test
    void testPuzzleInput() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day8.txt");
        Day8 day = new Day8(testInputArray);
        System.out.println(day.execute());
    }

    @Test
    void testExampleInputPart2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day8Example.txt");
        Day8 day = new Day8(testInputArray);
        assertEquals(8, day.execute2());
    }

    @Test
    void testPuzzleInputPart2() throws IOException, URISyntaxException {
        String[] testInputArray = FileReader.read("Day8.txt");
        Day8 day = new Day8(testInputArray);
        System.out.println(day.execute2());
    }
}
