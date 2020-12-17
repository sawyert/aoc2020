package com.tim.aoc2020.day17;

import java.util.ArrayList;
import java.util.List;

public class Day17 {

    private Network startingNetwork = new Network();

    public Day17(String[] input) {
        int z = Network.GRID_SIZE / 2;
        for (int y=Network.GRID_SIZE / 2;y<input.length + Network.GRID_SIZE / 2;y++) {
            String line = input[y-Network.GRID_SIZE / 2];
            for (int x=Network.GRID_SIZE / 2; x<line.length()+Network.GRID_SIZE / 2; x++){
                char eachChar = line.charAt(x-Network.GRID_SIZE / 2);
                Cube newCube = new Cube(x,y,z, eachChar);
                startingNetwork.add(newCube);
            }
        }
    }

    public long execute(int rounds) {
        Network newNetwork = startingNetwork;
        for (int i=0; i<rounds;i++){
            System.out.println(("Round " + i));
            newNetwork = newNetwork.executeRound();
        }

        return newNetwork.countActiveCubes();
    }
}
