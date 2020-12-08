package com.tim.aoc2020.day8;

import java.util.Map;

public class Instruction {
    private InstructionType instructionType;
    private final int parameter;
    private int visits = 0;

    public InstructionType getInstructionType() {
        return instructionType;
    }

    public int getParameter() {
        return parameter;
    }

    public Instruction(String operation) {
        String[] parts = operation.split(" ");
        this.instructionType = InstructionType.from(parts[0]);
        this.parameter = Integer.parseInt(parts[1]);
    }

    public int execute(Map<Register,Integer> globals) throws DoneException {
        this.visits++;

        if (visits > 1) {
            throw new DoneException(globals.get(Register.ACCUMULATOR));
        }
        switch(instructionType){
            case ACC:
                Integer accumulator = globals.get(Register.ACCUMULATOR);
                Integer newValue = accumulator + parameter;
                globals.put(Register.ACCUMULATOR, newValue);

                Integer nextInstructionAfterAcc = globals.get(Register.NEXT_INSTRUCTION);
                return nextInstructionAfterAcc + 1;
            case JMP:
                Integer nextInstructionToJmp = globals.get(Register.NEXT_INSTRUCTION);
                return nextInstructionToJmp + parameter;
            case NOP:
                Integer nextInstructionAfterNop = globals.get(Register.NEXT_INSTRUCTION);
                return nextInstructionAfterNop + 1;
        }
        throw new UnsupportedOperationException();
    }

    public void mutate() {
        if (this.instructionType == InstructionType.JMP) {
            this.instructionType = InstructionType.NOP;
        }
        else if (this.instructionType == InstructionType.NOP) {
            this.instructionType = InstructionType.JMP;
        }
    }
}
