package com.tim.aoc2020.day17;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Network {

    public static final int GRID_SIZE = 200;

    private Cube[][][] cubes = new Cube[GRID_SIZE][GRID_SIZE][GRID_SIZE];

    public Network executeRound() {
        Network newNetwork = new Network();
        for (int x = 0; x<GRID_SIZE; x++) {
            for (int y = 0; y<GRID_SIZE; y++) {
                for (int z = 0; z<GRID_SIZE; z++) {
                    Cube cube = cubes[x][y][z];
                    if (cube != null) {
                        Cube flippedCube = cube.flip();
                        newNetwork.add(flippedCube);
                    }
                }
            }
        }
        return newNetwork;
    }

    public long countActiveCubes() {
        long count = 0;
        for (int x = 0; x<GRID_SIZE; x++) {
            for (int y = 0; y<GRID_SIZE; y++) {
                for (int z = 0; z < GRID_SIZE; z++) {
                    Cube cube = cubes[x][y][z];
                    if (cube != null && cube.isActive()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void add(Cube newCube) {
        this.cubes[newCube.getX()][newCube.getY()][newCube.getZ()] = newCube;
        this.relink();
    }

    private void relink() {
        for (int x = 0; x<GRID_SIZE; x++) {
            for (int y = 0; y<GRID_SIZE; y++) {
                for (int z = 0; z < GRID_SIZE; z++) {
                    Cube cube = cubes[x][y][z];
                    if (cube == null) {
                        continue;
                    }
                    cube.clearLinks();

                    // link this z in 2 dimensions
                    this.addCube(cube, x - 1, y - 1, z);
                    this.addCube(cube, x - 1, y, z);
                    this.addCube(cube, x - 1, y + 1, z);
                    this.addCube(cube, x + 1, y - 1, z);
                    this.addCube(cube, x + 1, y, z);
                    this.addCube(cube, x + 1, y + 1, z);
                    this.addCube(cube, x, y - 1, z);
                    this.addCube(cube, x, y + 1, z);

                    // link z + 1 in 2 dimensions
                    this.addCube(cube, x - 1, y - 1, z + 1);
                    this.addCube(cube, x - 1, y, z + 1);
                    this.addCube(cube, x - 1, y + 1, z + 1);
                    this.addCube(cube, x + 1, y - 1, z + 1);
                    this.addCube(cube, x + 1, y, z + 1);
                    this.addCube(cube, x + 1, y + 1, z + 1);
                    this.addCube(cube, x, y - 1, z + 1);
                    this.addCube(cube, x, y, z + 1);
                    this.addCube(cube, x, y + 1, z + 1);

                    // link z - 1 in 2 dimensions;
                    this.addCube(cube, x - 1, y - 1, z - 1);
                    this.addCube(cube, x - 1, y, z - 1);
                    this.addCube(cube, x - 1, y + 1, z - 1);
                    this.addCube(cube, x + 1, y - 1, z - 1);
                    this.addCube(cube, x + 1, y, z - 1);
                    this.addCube(cube, x + 1, y + 1, z - 1);
                    this.addCube(cube, x, y - 1, z - 1);
                    this.addCube(cube, x, y, z - 1);
                    this.addCube(cube, x, y + 1, z - 1);
                }
            }
        }
    }

    private void addCube(Cube cube, int x, int y, int z) {
        if (x <0 || x > GRID_SIZE - 1 || y < 0 || y > GRID_SIZE - 1 || z < 0 || z > GRID_SIZE - 1) {
            return;
        }

        boolean found = false;
        Cube eachCube = cubes[x][y][z];
        if (eachCube != null) {
            cube.addLink(eachCube);
            found = true;
        }

        if (!found && cube.isActive()) {
            Cube newCube = new Cube(x,y,z,'.');
            cubes[x][y][z] = newCube;
        }
    }
}
