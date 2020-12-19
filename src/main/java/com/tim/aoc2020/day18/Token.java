package com.tim.aoc2020.day18;

public abstract class Token {
    private Token previous;
    private Token next;
    protected Long number;
    protected Integer depth;

    public void setPrevious(Token previousToken) {
        this.previous = previousToken;
    }

    public void setNext(Token nextToken) {
        this.next = nextToken;
    }

    public long getNumber() {
        return this.number;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }
}
