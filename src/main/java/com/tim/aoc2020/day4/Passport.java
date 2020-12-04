package com.tim.aoc2020.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

    private Map<String,String> attributes = new HashMap<>();

    public void addAttribute(String key, String value){
        attributes.put(key, value);
    }

    public boolean isValidPart1() {
        if (attributes.containsKey("byr") == false) {
            return false;
        }
        if (attributes.containsKey("iyr") == false) {
            return false;
        }
        if (attributes.containsKey("eyr") == false) {
            return false;
        }
        if (attributes.containsKey("hgt") == false) {
            return false;
        }
        if (attributes.containsKey("hcl") == false) {
            return false;
        }
        if (attributes.containsKey("ecl") == false) {
            return false;
        }
        if (attributes.containsKey("pid") == false) {
            return false;
        }

        return true;
    }

    public boolean isValidPart2() {
        boolean returnValue = this.isValidPart1();

        if (returnValue == false) {
            System.out.println("Part 1 failed");
        }

        returnValue = returnValue && this.validateBetweenInclusive(this.attributes.get("byr"), 1920, 2002);
        returnValue = returnValue && this.validateBetweenInclusive(this.attributes.get("iyr"), 2010, 2020);
        returnValue = returnValue && this.validateBetweenInclusive(this.attributes.get("eyr"), 2020, 2030);
        returnValue = returnValue && this.validateHeight(this.attributes.get("hgt"));
        returnValue = returnValue && this.validateHairColor(this.attributes.get("hcl"));
        returnValue = returnValue && this.validateEyeColour(this.attributes.get("ecl"));
        returnValue = returnValue && this.validatePassportNumber(this.attributes.get("pid"));

        return returnValue;
    }

    private boolean validatePassportNumber(String valueString) {
        Pattern pattern = Pattern.compile("[0-9]{9}");
        Matcher m = pattern.matcher(valueString);
        if (m.find() && valueString.length() == 9) {
            return true;
        }
        System.out.println(valueString + " is not a valid passport number");
        return false;
    }


    private boolean validateEyeColour(String valueString) {
        boolean eyeColourCorrect = valueString.equals("amb") || valueString.equals("blu") || valueString.equals("brn") || valueString.equals("gry") || valueString.equals("grn") || valueString.equals("hzl") || valueString.equals("oth");
        if (eyeColourCorrect) {
            return true;
        }
        System.out.println(valueString + " is not a valid eye colour");
        return false;
    }

    private boolean validateHairColor(String valueString) {
        Pattern pattern = Pattern.compile("#[0-9a-f]+");
        Matcher m = pattern.matcher(valueString);
        if (m.find() && valueString.length() == 7) {
            return true;
        }
        System.out.println(valueString + " is not a valid hair colour");
        return false;
    }

    private boolean validateHeight(String valueString) {
        String units;
        if (valueString.endsWith("cm")) {
            units = "cm";
            valueString = valueString.substring(0, valueString.length() - 2);
        }
        else if (valueString.endsWith("in")) {
            units = "in";
            valueString = valueString.substring(0, valueString.length() - 2);
        }
        else
        {
            System.out.println(valueString + " has no units");
            return false;
        }

        int number = 0;
        try {
            number = Integer.parseInt(valueString);
        }
        catch (NumberFormatException ex) {
            System.out.println(valueString + " doesn't have a valid number");
            return false;
        }

        if (!units.equals("cm") && !units.equals("in")) {
            System.out.println(valueString + " doesn't have cm or in");
            return false;
        }

        if ("cm".equals(units) && (number < 150 || number > 193)){
            System.out.println(valueString + " is cm but outside range");
            return false;
        }

        if ("in".equals(units) && (number < 59 || number > 76)) {
            System.out.println(valueString + " is in but outside range");
            return false;
        }

        return true;
    }

    private boolean validateBetweenInclusive(String valueString, int lower, int upper) {
        int value = Integer.parseInt(valueString.trim());
        if (value < lower || value > upper) {
            System.out.println(valueString + " isn't between");
            return false;
        }
        return true;
    }
}
