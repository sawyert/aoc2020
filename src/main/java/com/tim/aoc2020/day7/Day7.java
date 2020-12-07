package com.tim.aoc2020.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day7 {

    private final String[] input;
    private List<Node> allNodes = new ArrayList<>();

    public Day7(String[] input){
        this.input = input;
    }

    public void parseAndLink() {
        // parse
        for (String eachLine : input) {
            Node eachNode = new Node(eachLine);
            allNodes.add(eachNode);
        }

        // link
        for (Node eachNode : allNodes) {
            for (ChildNode eachChild : eachNode.getChildren()){
                eachChild.findLink(allNodes);
            }
        }
    }

    public int execute() {
        this.parseAndLink();

        Set<Node> parentNodes = new HashSet<>();
        for (Node eachNode : allNodes) {
            if (eachNode.canContain("shiny gold"))
            {
                parentNodes.add(eachNode);
            }
        }

        return parentNodes.size();
    }

    public int execute2() {
        this.parseAndLink();

        Node goldNode = null;
        for (Node eachNode : allNodes) {
            if (eachNode.getColour().equals("shiny gold")){
                goldNode = eachNode;
            }
        }

        return goldNode.countBagsInside();
    }
}
