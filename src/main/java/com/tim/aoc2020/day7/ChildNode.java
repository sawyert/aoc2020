package com.tim.aoc2020.day7;

import java.util.List;

public class ChildNode {
    public final int count;
    public final String colour;
    public Node linkNode;

    public ChildNode(int count, String colour) {
        this.colour = colour;
        this.count = count;
    }

    public void findLink(List<Node> allNodes) {
        for (Node eachNode : allNodes) {
            if (eachNode.getColour().equals(this.colour)){
                this.linkNode = eachNode;
            }
        }
    }
}
