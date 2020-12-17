package com.tim.aoc2020.day16;

import java.util.*;

public class Day16 {
    private String[] rules;
    private String[] tickets;

    public Day16(String[] rules, String[] tickets) {
        this.rules = rules;
        this.tickets = tickets;
    }

    public long execute() {
        Map<Integer, Boolean> validRanges = new HashMap<>();
        for (String rule: rules) {
            String[] titleSplit = rule.split(":");
            String rulePortion = titleSplit[1].trim();
            String[] ruleSplit = rulePortion.split("or");
            for (String eachRule : ruleSplit) {
                String[] eachRuleRange = eachRule.split("-");
                int lowerRange = Integer.parseInt(eachRuleRange[0].trim());
                int upperRange = Integer.parseInt(eachRuleRange[1].trim());
                for (int i=lowerRange;i<=upperRange;i++) {
                    validRanges.put(i, true);
                }
            }
        }

        long total = 0;

        for (String ticket: tickets) {
            String[] values = ticket.split(",");
            for (String eachValue : values) {
                int number = Integer.parseInt(eachValue.trim());
                if (validRanges.get(number) == null) {
                    // not a valid range
                    total += number;
                }
            }
        }

        return total;
    }

    public long execute2(String myTicket) {
        Map<Integer, Boolean> validRanges = new HashMap<>();
        for (String rule: rules) {
            String[] titleSplit = rule.split(":");
            String rulePortion = titleSplit[1].trim();
            String[] ruleSplit = rulePortion.split("or");
            for (String eachRule : ruleSplit) {
                String[] eachRuleRange = eachRule.split("-");
                int lowerRange = Integer.parseInt(eachRuleRange[0].trim());
                int upperRange = Integer.parseInt(eachRuleRange[1].trim());
                for (int i=lowerRange;i<=upperRange;i++) {
                    validRanges.put(i, true);
                }
            }
        }

        List<String> validTickets = new ArrayList<>();

        for (String ticket: tickets) {
            boolean valid = true;
            String[] values = ticket.split(",");
            for (String eachValue : values) {
                int number = Integer.parseInt(eachValue.trim());
                if (validRanges.get(number) == null) {
                    // not a valid range
                    valid = false;
                }
            }

            if (valid) {
                validTickets.add(ticket);
            }
        }

        System.out.println("Started with " + this.tickets.length + " tickets");
        System.out.println("Found " + validTickets.size() + " valid tickets");

        Map<Integer, List<Integer>> columnValues = new HashMap<>();
        for (int column=0; column<20; column++) {
            columnValues.put(column, new ArrayList<>());
        }

        for (String ticket : validTickets) {
            String[] ticketValues = ticket.split(",");
            for (int column=0; column<20; column++) {
                columnValues.get(column).add(Integer.parseInt(ticketValues[column]));
            }
        }

        Map<String,Integer> columnToRuleMapping = new HashMap<>();

        List<String> rulesToCheck = new ArrayList<>();
        rulesToCheck.addAll(Arrays.asList(this.rules));


        while (true) {
            for (int column = 0; column<20; column++) {
                List<String> matchingRules = new ArrayList<>();
                List<Integer> thisColumnValues = columnValues.get(column);
                if (thisColumnValues == null) {
                    continue;
                }
                for (String rule : rulesToCheck) {
                    if (this.columnFitsRule(thisColumnValues, rule)) {
                        matchingRules.add(rule);
                    }
                }
                if (matchingRules.size() == 1) {
                    // we've dealt with this column
                    columnToRuleMapping.put(matchingRules.get(0), column);
                    rulesToCheck.remove(matchingRules.get(0));
                    columnValues.put(column, null);
                }
            }
            System.out.println(rulesToCheck.size() + " left to process");

            if (rulesToCheck.size() == 0) {
                break;
            }
        }

        String[] myTicketFields = myTicket.split(",");
        long result = 1;
        for (String eachRule : columnToRuleMapping.keySet()) {
            if (eachRule.startsWith("departure")) {
                Integer column = columnToRuleMapping.get(eachRule);
                result *= Integer.parseInt(myTicketFields[column]);
            }
        }
        return result;
    }

    private boolean columnFitsRule(List<Integer> thisColumnValues, String rule) {
        String[] titleSplit = rule.split(":");
        String ruleName = titleSplit[0];
        String rulePortion = titleSplit[1].trim();
        String[] ruleSplit = rulePortion.split("or");
        String firstRule = ruleSplit[0];
        String secondRule = ruleSplit[1];
        String[] firstRuleRange = firstRule.split("-");
        int lowerRange1 = Integer.parseInt(firstRuleRange[0].trim());
        int upperRange1 = Integer.parseInt(firstRuleRange[1].trim());
        String[] secondRuleRange = secondRule.split("-");
        int lowerRange2 = Integer.parseInt(secondRuleRange[0].trim());
        int upperRange2 = Integer.parseInt(secondRuleRange[1].trim());

        boolean valid = true;
        for (Integer eachColumnValue : thisColumnValues) {
            if (!isWithinRange(eachColumnValue, lowerRange1, upperRange1) && !isWithinRange(eachColumnValue, lowerRange2, upperRange2)){
                valid = false;
            }
        }
        return valid;
    }

    private boolean isWithinRange(int eachValue, int lower, int upper) {
        return eachValue >= lower && eachValue <= upper;
    }
}
