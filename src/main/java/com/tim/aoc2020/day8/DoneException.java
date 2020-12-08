package com.tim.aoc2020.day8;

public class DoneException extends Exception {
    public DoneException(int value){
        super("" + value);
    }
}
