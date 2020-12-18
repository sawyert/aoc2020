package com.tim.aoc2020.day17;

import java.util.Date;

public class Day17Part2 {

    private Network4d startingNetwork = new Network4d();

    public Day17Part2(String[] input) {
        int w = Network4d.GRID_SIZE / 2;
        int z = Network4d.GRID_SIZE / 2;
        for (int y=Network4d.GRID_SIZE / 2;y<input.length + Network4d.GRID_SIZE / 2;y++) {
            String line = input[y-Network4d.GRID_SIZE / 2];
            for (int x=Network4d.GRID_SIZE / 2; x<line.length()+Network4d.GRID_SIZE / 2; x++){
                char eachChar = line.charAt(x-Network4d.GRID_SIZE / 2);
                Cube4d newCube = new Cube4d(x,y,z,w, eachChar);
                startingNetwork.add(newCube);
            }
        }
    }

    public long execute(int rounds) {
        Network4d newNetwork = startingNetwork;
        for (int i=0; i<rounds;i++){
            System.out.println((new Date().toString() + " Round " + i));
            newNetwork = newNetwork.executeRound();
        }

        return newNetwork.countActiveCubes();
    }
}
