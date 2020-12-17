package com.tim.aoc2020.day17;

import java.util.ArrayList;
import java.util.List;

public class Cube4d {
    private final boolean active;
    private final int x;
    private final int y;
    private final int z;
    private final int w;

    private List<Cube4d> links = new ArrayList<>();

    public Cube4d(int x, int y, int z, int w, char eachChar) {
        if (eachChar == '#') {
            this.active = true;
        }
        else {
            this.active = false;
        }
        this.x=x;
        this.y=y;
        this.z=z;
        this.w=w;
    }

    public boolean isActive() {
        return active;
    }

    private int neighboursActive() {
        int result = 0;
        for (Cube4d eachNeighbour : this.links) {
            if (eachNeighbour.active) {
                result += 1;
            }
        }
        return result;
    }

    public Cube4d flip() {
        if (this.active && (neighboursActive() == 2 || neighboursActive() == 3)) {
            return new Cube4d(this.x, this.y, this.z, this.w, '#');
        }
        else if (!this.active && neighboursActive() == 3) {
            return new Cube4d(this.x, this.y, this.z, this.w, '#');
        }
        return new Cube4d(this.x, this.y, this.z, this.w, '.');
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

    public int getW() { return this.w; }

    public void clearLinks() {
        this.links = new ArrayList<>();
    }

    public void addLink(Cube4d eachCube) {
        this.links.add(eachCube);
    }
}
