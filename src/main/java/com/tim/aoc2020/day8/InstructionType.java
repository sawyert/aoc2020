package com.tim.aoc2020.day8;

public enum InstructionType {
    NOP,
    ACC,
    JMP,
    ;

    public static InstructionType from(String part) {
        switch (part) {
            case "nop":
                return NOP;
            case "jmp":
                return JMP;
            case "acc":
                return ACC;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
