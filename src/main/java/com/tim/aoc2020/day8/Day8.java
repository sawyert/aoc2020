package com.tim.aoc2020.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {
    private final String[] input;
    private List<Instruction> instructionList;

    public Day8(String[] input){
        this.input = input;
        this.buildInstructionList();
    }

    private void buildInstructionList() {
        this.instructionList = new ArrayList<>();
        for (String inputLine : this.input){
            Instruction instr = new Instruction(inputLine);
            this.instructionList.add(instr);
        }
    }

    public int execute() {
        Map<Register, Integer> globals = new HashMap<>();
        globals.put(Register.NEXT_INSTRUCTION, 0);
        globals.put(Register.ACCUMULATOR, 0);

        try {

            while (true) {
                Instruction instruction = instructionList.get(globals.get(Register.NEXT_INSTRUCTION));
                int nextLocation = instruction.execute(globals);
                globals.put(Register.NEXT_INSTRUCTION, nextLocation);
            }
        }
        catch (DoneException ex) {
            return Integer.parseInt(ex.getMessage());
        }
    }

    public int execute2() {
        for (int i=0; i<input.length; i++) {
            this.buildInstructionList();
            Instruction mutated = instructionList.get(i);
            mutated.mutate();

            Map<Register, Integer> globals = new HashMap<>();
            globals.put(Register.NEXT_INSTRUCTION, 0);
            globals.put(Register.ACCUMULATOR, 0);

            try {
                while (globals.get(Register.NEXT_INSTRUCTION) != instructionList.size()) {
                    Instruction instruction = instructionList.get(globals.get(Register.NEXT_INSTRUCTION));
                    int nextLocation = instruction.execute(globals);
                    globals.put(Register.NEXT_INSTRUCTION, nextLocation);
                }
            }
            catch (DoneException ex) {
                continue;
            }

            return globals.get(Register.ACCUMULATOR);
        }

        throw new UnsupportedOperationException("Broken");
    }
}
