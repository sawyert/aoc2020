package com.tim.aoc2020.day18;

public class NumberToken extends Token {
    public NumberToken(String eachToken) {
        this.number = Long.parseLong(eachToken);
    }
    public NumberToken(long number) {
        this.number = number;
    }
}
