package com.tim.aoc2020.day18;

import java.util.ArrayList;
import java.util.List;

public class Day18 {
    private String[] input;

    public Day18(String[] input) {
        this.input = input;
    }

    public long execute() {
        long total = 0;
        for (String inputLine : input) {
            total += this.processLine(inputLine);
        }
        return total;
    }

    private long processLine(String inputLine) {
        System.out.println(inputLine);
        TokenizedString tokenizedString = new TokenizedString();
        String[] tokens = inputLine.split(" ");
        for (String eachToken : tokens) {
            List<Token> endBracketTokens = new ArrayList<>();

            switch (eachToken.trim()) {
                case "+" :
                    tokenizedString.add(new AddToken());
                    continue;
                case "*":
                    tokenizedString.add(new MultiplyToken());
                    continue;
            }

            while (eachToken.startsWith("(")) {
                tokenizedString.add(new OpenBracketToken());
                eachToken = eachToken.substring(1);
            }

            while (eachToken.endsWith(")")) {
                endBracketTokens.add(new CloseBracketToken());
                eachToken = eachToken.substring(0, eachToken.length() - 1);
            }

            tokenizedString.add(new NumberToken(eachToken));
            tokenizedString.addAll(endBracketTokens);
        }

        return tokenizedString.execute();
    }
}
