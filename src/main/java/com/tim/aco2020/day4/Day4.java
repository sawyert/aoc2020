package com.tim.aco2020.day4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4 {
    private String[] inputArray;
    private Set<Passport> passports = new HashSet<>();

    public Day4(String[] testInputArray) {
        this.inputArray = testInputArray;
        this.parsePassports();
    }

    private void parsePassports() {
        Passport passport = new Passport();
        for (String eachLine : inputArray) {
            if (eachLine.trim().length() == 0) {
                passports.add(passport);
                passport = new Passport();
                continue;
            }

            String[] lineSplit = eachLine.split(" ");
            for (String eachAttribute : lineSplit) {
                String[] attributeSplit = eachAttribute.split(":");
                passport.addAttribute(attributeSplit[0], attributeSplit[1]);
            }
        }
        passports.add(passport);
    }

    public long execute() {
        return passports.stream().filter(a -> a.isValidPart1()).count();
    }

    public long execute2() {
        return passports.stream().filter(a -> a.isValidPart2()).count();
    }
}
