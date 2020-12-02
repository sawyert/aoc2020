package com.tim.aco2020.day2;

public class Day2 {
    String[] input;

    public Day2(String[] testInput) {
        this.input = testInput;
    }

    public long execute() {
        long count = 0;

        for (int i=0; i<input.length; i++) {
            count += this.processLine(input[i]);
        }

        return count;
    }

    private long processLine(String s) {
        String[] parts = s.split(":");
        String rule = parts[0].trim();
        String toProcess = parts[1].trim();

        String[] ruleParts = rule.split(" ");
        String ruleRange = ruleParts[0].trim();
        String ruleLetter = ruleParts[1].trim();

        String[] ruleRangeParts = ruleRange.split("-");
        String ruleLowerRange = ruleRangeParts[0].trim();
        String ruleUpperRange = ruleRangeParts[1].trim();

        int  ruleLowerRangeInt = Integer.parseInt(ruleLowerRange);
        int ruleUpperRangeInt = Integer.parseInt(ruleUpperRange);

        return this.processLine(toProcess, ruleLetter.charAt(0), ruleLowerRangeInt, ruleUpperRangeInt);
    }

    private long processLine(String toProcess, char ruleLetter, int ruleLowerRangeInt, int ruleUpperRangeInt) {
        int count = 0;
        char[] charactersInPassword = toProcess.toCharArray();
        for (int i=0; i<charactersInPassword.length; i++) {
            if (charactersInPassword[i] == ruleLetter) {
                count++;
            }
        }

        if (count >= ruleLowerRangeInt && count <= ruleUpperRangeInt) {
            return 1;
        }

        return 0;
    }
}
