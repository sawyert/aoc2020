package com.tim.aco2020.day3;

public class Day3 {

    final String[] inputArray;
    final int width;


    public Day3(String[] inputArray) {
        this.inputArray = inputArray;
        this.width = this.inputArray[0].length();
    }

    public long execute(int right, int down) {
        StringBuilder encountered = new StringBuilder();
        int horizontal = right;
        for (int i=down; i<this.inputArray.length; i += down) {
            String line = this.inputArray[i];

            encountered.append(line.charAt(horizontal));

            horizontal = horizontal + right;
            while (horizontal >= width) {
                horizontal -= width;
            }
        }

        return encountered.toString().chars().filter(map -> map == '#').count();
    }

    public long executePart2() {
        long answer = this.execute(1,1);
        answer *= this.execute(3,1);
        answer *= this.execute(5,1);
        answer *= this.execute(7,1);
        answer *= this.execute(1,2);
        return answer;
    }
}
