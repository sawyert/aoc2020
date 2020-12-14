package com.tim.aoc2020.day14;

public class Day14 {
    private String[] input;
    private String currentBitmask;
    private Long[] memorySpace = new Long[100000];

    public Day14(String[] input) {
        this.input = input;


    }

    public long execute() {
        for (String eachLine : input) {
            if (eachLine.startsWith("mask")) {
                processMask(eachLine);
            }
            else if (eachLine.startsWith("mem")) {
                processMem(eachLine);
            }
        }

        return this.calcAnswer();
    }

    private long calcAnswer() {
        long total = 0;
        for (Long eachValue : memorySpace) {
            if (eachValue != null) {
                total += eachValue;
            }
        }
        return total;
    }

    private void processMem(String eachLine) {
        String[] parts = eachLine.split("=");
        Integer memoryPosition = Integer.parseInt(parts[0].substring(parts[0].indexOf("[") + 1, parts[0].indexOf("]")));
        Integer memoryValue = Integer.parseInt(parts[1].trim());

        Long mangledMemoryValue = this.mangleMemoryValue(memoryValue);

        memorySpace[memoryPosition] = mangledMemoryValue;
    }

    private Long mangleMemoryValue(Integer memoryValue) {
        String binaryMemoryValueToSet = Integer.toBinaryString(memoryValue);

        while (binaryMemoryValueToSet.length() < this.currentBitmask.length()) {
            binaryMemoryValueToSet = "0" + binaryMemoryValueToSet;
        }

        StringBuilder memValue = new StringBuilder(binaryMemoryValueToSet);

        for (int i=this.currentBitmask.length()-1; i>=0; i--) {
            char bitmaskChar = this.currentBitmask.charAt(i);
            if (bitmaskChar != 'X') {
                memValue.setCharAt(i, bitmaskChar);
            }
        }

        Long returnValue = Long.parseLong(memValue.toString(), 2);

        return returnValue;
    }

    private void processMask(String eachLine) {
        this.currentBitmask = eachLine.substring(7).trim();
    }
}
