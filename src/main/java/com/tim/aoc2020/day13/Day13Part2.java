package com.tim.aoc2020.day13;

import java.util.ArrayList;
import java.util.List;

public class Day13Part2 {

    private List<Integer> busIds = new ArrayList<>();
    private List<Integer> bi = new ArrayList<>();
    private long productOfAlLMods = 1;

    public Day13Part2(String[] input) {
        String inputArray = input[1];
        String[] inputs = inputArray.split(",");

        for (int i=0;i<inputs.length;i++) {
            if (!inputs[i].equals("x")) {
                Integer inputBusId = Integer.parseInt(inputs[i]);
                this.busIds.add(inputBusId);
                this.bi.add(((-1 * i) % inputBusId) + inputBusId);
                this.productOfAlLMods *= inputBusId;
            }
        }
    }

    public long execute() {
        System.out.println(busIds);

        ArrayList<Long> ni = new ArrayList<>();
        ArrayList<Integer> xi  = new ArrayList<>();

        for (int i=0; i<busIds.size(); i++) {
            ni.add(this.productOfAlLMods / busIds.get(i));
            xi.add(inverse(ni.get(i), busIds.get(i)));
        }

        long answer = 0;
        for (int i=0; i<busIds.size(); i++) {
            answer += bi.get(i) * ni.get(i) * xi.get(i);
        }
        answer %= productOfAlLMods;
        return answer;
    }

    public int inverse(long ni, int busId) {
        int xi = 1;
        while ((ni * xi) % busId != 1) {
            xi++;
        }
        return xi;
    }
}
