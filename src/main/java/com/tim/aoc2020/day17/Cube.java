package com.tim.aoc2020.day17;

import java.util.ArrayList;
import java.util.List;

public class Cube {
    private final boolean active;
    private final int x;
    private final int y;
    private final int z;

    private List<Cube> links = new ArrayList<>();

    public Cube(int x, int y, int z, char eachChar) {
        System.out.println("Creating " + x + ", " + y + ", " + z+ ", " + eachChar);
        if (eachChar == '#') {
            this.active = true;
        }
        else {
            this.active = false;
        }
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public boolean isActive() {
        return active;
    }

    private int neighboursActive() {
        int result = 0;
        for (Cube eachNeighbour : this.links) {
            if (eachNeighbour.active) {
                result += 1;
            }
        }
        return result;
    }

    public Cube flip() {
        if (this.active && (neighboursActive() == 2 || neighboursActive() == 3)) {
            return new Cube(this.x, this.y, this.z, '#');
        }
        else if (!this.active && neighboursActive() == 3) {
            return new Cube(this.x, this.y, this.z, '#');
        }
        return new Cube(this.x, this.y, this.z, '.');
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public void clearLinks() {
        this.links = new ArrayList<>();
    }

    public void addLink(Cube eachCube) {
        this.links.add(eachCube);
    }
}
