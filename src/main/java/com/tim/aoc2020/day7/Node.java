package com.tim.aoc2020.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
    public String getColour() {
        return colour;
    }

    public List<ChildNode> getChildren() {
        return children;
    }

    private final String colour;
    private final List<ChildNode> children = new ArrayList<>();

    public Node(String spec) {
        String[] contains = spec.split("bags contain");
        this.colour = contains[0].trim();

        String[] contents = contains[1].split(",");
        for (int i=0; i < contents.length; i++) {
            String eachChild = contents[i].trim();
            if (eachChild.endsWith(".")) {
                eachChild = eachChild.substring(0, eachChild.length()-1).trim();
            }
            if (eachChild.endsWith("bag")) {
                eachChild = eachChild.substring(0, eachChild.length() - "bag".length()).trim();
            }
            if (eachChild.endsWith("bags")) {
                eachChild = eachChild.substring(0, eachChild.length() - "bags".length()).trim();
            }
            int firstSpacePosition = eachChild.indexOf(" ");
            String countAsString = eachChild.substring(0, firstSpacePosition);
            if (countAsString.equals("no")){
                continue;
            }
            int count = Integer.parseInt(countAsString);
            String colourName = eachChild.substring(firstSpacePosition).trim();

           ChildNode childNode = new ChildNode(count, colourName);
           this.children.add(childNode);
        }
    }

    public boolean canContain(String bagColour) {
        for (ChildNode eachChild : this.getChildren()) {
            if (eachChild.colour.equals(bagColour)) {
                return true;
            }
        }

        for (ChildNode eachChild : this.getChildren()) {
            if (eachChild.linkNode.canContain(bagColour)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.getColour();
    }

    public int countBagsInside() {
        int count = 0;
        for (ChildNode eachChild : this.getChildren()) {
            count += eachChild.count;
            count += eachChild.count * eachChild.linkNode.countBagsInside();
        }

        return count;
    }
}
