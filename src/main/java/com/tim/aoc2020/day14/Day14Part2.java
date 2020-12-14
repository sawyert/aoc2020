package com.tim.aoc2020.day14;

import java.util.*;

public class Day14Part2 {
    private String[] input;
    private String currentBitmask;
    private Map<Long, Long> memorySpace = new HashMap<>();

    public Day14Part2(String[] input) {
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
        for (Long eachValue : memorySpace.values()) {
            if (eachValue != null) {
                total += eachValue;
            }
        }
        return total;
    }

    private void processMem(String eachLine) {
        String[] parts = eachLine.split("=");
        Integer memoryPosition = Integer.parseInt(parts[0].substring(parts[0].indexOf("[") + 1, parts[0].indexOf("]")));
        Long memoryValue = Long.parseLong(parts[1].trim());

        List<Long> locationsToWriteTo = this.calcLocationsToWriteTo(memoryPosition);

        for (Long location : locationsToWriteTo) {
            memorySpace.put(location, memoryValue);
        }
    }

    private List<Long> calcLocationsToWriteTo(Integer memoryPosition) {
        String binaryMemoryPosition = Integer.toBinaryString(memoryPosition);

        while (binaryMemoryPosition.length() < this.currentBitmask.length()) {
            binaryMemoryPosition = "0" + binaryMemoryPosition;
        }

        StringBuilder memPosition = new StringBuilder(binaryMemoryPosition);

        Set<String> locationsToSet = new HashSet<>();

        for (int i=this.currentBitmask.length()-1; i>=0; i--) {
            char bitmaskChar = this.currentBitmask.charAt(i);

            // find the 1's in the mask, apply 1 to replace the position in the memory location
            if (bitmaskChar == '1') {
                memPosition.setCharAt(i, '1');

            }
            if (bitmaskChar == 'X') {
                memPosition.setCharAt(i, 'X');
            }
        }
        locationsToSet.add(memPosition.toString());

        // find the X's in the mask, apply both 1 and 0 to the X's in the mask
        boolean xFound = false;
        List<String> removeList = new ArrayList<>();
        List<String> addList = new ArrayList<>();
        while (true) {
            for (String location : locationsToSet) {
                xFound = false;
                if (location.contains("X")) {
                    xFound = true;
                }

                StringBuilder modifiedLocation = new StringBuilder(location);
                int xIndex = location.indexOf("X");
                if (xIndex > -1) {
                    removeList.add(location);
                    modifiedLocation.setCharAt(xIndex, '0');
                    addList.add(modifiedLocation.toString());
                    modifiedLocation.setCharAt(xIndex, '1');
                    addList.add(modifiedLocation.toString());
                }
            }
            locationsToSet.removeAll(removeList);
            locationsToSet.addAll(addList);
            removeList = new ArrayList<>();
            addList = new ArrayList<>();

            if (xFound == false) break;
        }

        List<Long> locationsToReturn = new ArrayList<>();
        for (String eachLocation : locationsToSet) {
            locationsToReturn.add(Long.parseLong(eachLocation, 2));
        }

        return locationsToReturn;
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
