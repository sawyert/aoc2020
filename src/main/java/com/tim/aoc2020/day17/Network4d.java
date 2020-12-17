package com.tim.aoc2020.day17;

public class Network4d {

    public static final int GRID_SIZE = 100;

    private Cube4d[][][][] cubes = new Cube4d[GRID_SIZE][GRID_SIZE][GRID_SIZE][GRID_SIZE];

    public Network4d executeRound() {
        Network4d newNetwork = new Network4d();
        for (int x = 0; x<GRID_SIZE; x++) {
            for (int y = 0; y<GRID_SIZE; y++) {
                for (int z = 0; z<GRID_SIZE; z++) {
                    for (int w = 0; w<GRID_SIZE; w++) {
                        Cube4d cube = cubes[x][y][z][w];
                        if (cube != null) {
                            Cube4d flippedCube = cube.flip();
                            newNetwork.add(flippedCube);
                        }
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
                    for (int w = 0; w < GRID_SIZE; w++) {
                        Cube4d cube = cubes[x][y][z][w];
                        if (cube != null && cube.isActive()) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public void add(Cube4d newCube) {
        this.cubes[newCube.getX()][newCube.getY()][newCube.getZ()][newCube.getW()] = newCube;
        this.relink();
    }

    private void relink() {
        for (int x = 0; x<GRID_SIZE; x++) {
            for (int y = 0; y<GRID_SIZE; y++) {
                for (int z = 0; z < GRID_SIZE; z++) {
                    for (int w=0; w < GRID_SIZE; w++ ) {
                        Cube4d cube = cubes[x][y][z][w];
                        if (cube == null) {
                            continue;
                        }
                        cube.clearLinks();

                        // link this z in 2 dimensions
                        this.addCube(cube, x - 1, y - 1, z, w - 1);
                        this.addCube(cube, x - 1, y, z, w - 1);
                        this.addCube(cube, x - 1, y + 1, z, w - 1);
                        this.addCube(cube, x + 1, y - 1, z, w - 1);
                        this.addCube(cube, x + 1, y, z, w - 1);
                        this.addCube(cube, x + 1, y + 1, z, w - 1);
                        this.addCube(cube, x, y - 1, z, w - 1);
                        this.addCube(cube, x, y + 1, z, w - 1);
                        this.addCube(cube, x - 1, y - 1, z + 1, w - 1);
                        this.addCube(cube, x - 1, y, z + 1, w - 1);
                        this.addCube(cube, x - 1, y + 1, z + 1, w - 1);
                        this.addCube(cube, x + 1, y - 1, z + 1, w - 1);
                        this.addCube(cube, x + 1, y, z + 1, w - 1);
                        this.addCube(cube, x + 1, y + 1, z + 1, w - 1);
                        this.addCube(cube, x, y - 1, z + 1, w - 1);
                        this.addCube(cube, x, y, z + 1, w - 1);
                        this.addCube(cube, x, y, z, w - 1);
                        this.addCube(cube, x, y + 1, z + 1, w - 1);
                        this.addCube(cube, x - 1, y - 1, z - 1, w - 1);
                        this.addCube(cube, x - 1, y, z - 1, w - 1);
                        this.addCube(cube, x - 1, y + 1, z - 1, w - 1);
                        this.addCube(cube, x + 1, y - 1, z - 1, w - 1);
                        this.addCube(cube, x + 1, y, z - 1, w - 1);
                        this.addCube(cube, x + 1, y + 1, z - 1, w - 1);
                        this.addCube(cube, x, y - 1, z - 1, w - 1);
                        this.addCube(cube, x, y, z - 1, w - 1);
                        this.addCube(cube, x, y + 1, z - 1, w - 1);

                        this.addCube(cube, x - 1, y - 1, z, w);
                        this.addCube(cube, x - 1, y, z, w);
                        this.addCube(cube, x - 1, y + 1, z, w);
                        this.addCube(cube, x + 1, y - 1, z, w);
                        this.addCube(cube, x + 1, y, z, w);
                        this.addCube(cube, x + 1, y + 1, z, w);
                        this.addCube(cube, x, y - 1, z, w);
                        this.addCube(cube, x, y + 1, z, w);
                        this.addCube(cube, x - 1, y - 1, z + 1, w);
                        this.addCube(cube, x - 1, y, z + 1, w);
                        this.addCube(cube, x - 1, y + 1, z + 1, w);
                        this.addCube(cube, x + 1, y - 1, z + 1, w);
                        this.addCube(cube, x + 1, y, z + 1, w);
                        this.addCube(cube, x + 1, y + 1, z + 1, w);
                        this.addCube(cube, x, y - 1, z + 1, w);
                        this.addCube(cube, x, y, z + 1, w);
                        this.addCube(cube, x, y + 1, z + 1, w);
                        this.addCube(cube, x - 1, y - 1, z - 1, w);
                        this.addCube(cube, x - 1, y, z - 1, w);
                        this.addCube(cube, x - 1, y + 1, z - 1, w);
                        this.addCube(cube, x + 1, y - 1, z - 1, w);
                        this.addCube(cube, x + 1, y, z - 1, w);
                        this.addCube(cube, x + 1, y + 1, z - 1, w);
                        this.addCube(cube, x, y - 1, z - 1, w);
                        this.addCube(cube, x, y, z - 1, w);
                        this.addCube(cube, x, y + 1, z - 1, w);

                        this.addCube(cube, x - 1, y - 1, z, w + 1);
                        this.addCube(cube, x - 1, y, z, w + 1);
                        this.addCube(cube, x - 1, y + 1, z, w + 1);
                        this.addCube(cube, x + 1, y - 1, z, w + 1);
                        this.addCube(cube, x + 1, y, z, w + 1);
                        this.addCube(cube, x + 1, y + 1, z, w + 1);
                        this.addCube(cube, x, y - 1, z, w + 1);
                        this.addCube(cube, x, y + 1, z, w + 1);
                        this.addCube(cube, x - 1, y - 1, z + 1, w + 1);
                        this.addCube(cube, x - 1, y, z + 1, w + 1);
                        this.addCube(cube, x - 1, y + 1, z + 1, w + 1);
                        this.addCube(cube, x + 1, y - 1, z + 1, w + 1);
                        this.addCube(cube, x + 1, y, z + 1, w + 1);
                        this.addCube(cube, x + 1, y + 1, z + 1, w + 1);
                        this.addCube(cube, x, y - 1, z + 1, w + 1);
                        this.addCube(cube, x, y, z + 1, w + 1);
                        this.addCube(cube, x, y, z, w + 1);
                        this.addCube(cube, x, y + 1, z + 1, w + 1);
                        this.addCube(cube, x - 1, y - 1, z - 1, w + 1);
                        this.addCube(cube, x - 1, y, z - 1, w + 1);
                        this.addCube(cube, x - 1, y + 1, z - 1, w + 1);
                        this.addCube(cube, x + 1, y - 1, z - 1, w + 1);
                        this.addCube(cube, x + 1, y, z - 1, w + 1);
                        this.addCube(cube, x + 1, y + 1, z - 1, w + 1);
                        this.addCube(cube, x, y - 1, z - 1, w + 1);
                        this.addCube(cube, x, y, z - 1, w + 1);
                        this.addCube(cube, x, y + 1, z - 1, w + 1);
                    }
                }
            }
        }
    }

    private void addCube(Cube4d cube, int x, int y, int z, int w) {
        if (x <0 || x > GRID_SIZE - 1 || y < 0 || y > GRID_SIZE - 1 || z < 0 || z > GRID_SIZE - 1 || w < 0 || w > GRID_SIZE - 1) {
            return;
        }

        boolean found = false;
        Cube4d eachCube = cubes[x][y][z][w];
        if (eachCube != null) {
            cube.addLink(eachCube);
            found = true;
        }

        if (!found && cube.isActive()) {
            Cube4d newCube = new Cube4d(x,y,z,w,'.');
            cubes[x][y][z][w] = newCube;
        }
    }
}
