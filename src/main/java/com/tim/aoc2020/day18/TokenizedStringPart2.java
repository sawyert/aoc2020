package com.tim.aoc2020.day18;

import java.util.ArrayList;
import java.util.List;

public class TokenizedStringPart2 {
    List<Token> tokenizedString = new ArrayList<>();

    public void add(Token token) {
        this.tokenizedString.add(token);
    }

    public void addAll(List<Token> tokenList) {
        this.tokenizedString.addAll(tokenList);
    }

    private void relink() {
        // link forward and back
        Token previousToken = null;
        for (Token eachToken : tokenizedString) {
            eachToken.setPrevious(previousToken);
            if (previousToken != null) {
                previousToken.setNext(eachToken);
            }
            previousToken = eachToken;
        }
    }

    public long execute() {
        int maxDepth = this.numberBrackets();

        if (maxDepth > 0) {
            for (int i = maxDepth; i > 0; i--) {
                reduceBracket(i);
            }
        }

        Token result = this.reduce(tokenizedString);
        return result.number;

    }
    public Token reduce(List<Token> tokensToReduce) {

        if (tokensToReduce.size() == 0) {
            throw new UnsupportedOperationException("Nothing to reduce");
        }

        int i = 0;
        while (true) {
            NumberToken firstNumber = (NumberToken) tokensToReduce.get(i);
            Token sign = tokensToReduce.get(i+1);
            NumberToken secondNumber = (NumberToken) tokensToReduce.get(i+2);

            if (sign instanceof AddToken) {
                Token newToken = new NumberToken(firstNumber.getNumber() + secondNumber.getNumber());
                tokensToReduce.remove(i);
                tokensToReduce.remove(i);
                tokensToReduce.remove(i);
                tokensToReduce.add(i, newToken);
            }
            else {
                i += 2;
            }

            if (i + 2 >= tokensToReduce.size()) {
                break;
            }
        }

        i = 0;
        while (tokensToReduce.size() > 2) {
            NumberToken firstNumber = (NumberToken) tokensToReduce.get(i);
            Token sign = tokensToReduce.get(i + 1);
            NumberToken secondNumber = (NumberToken) tokensToReduce.get(i + 2);

            if (sign instanceof MultiplyToken) {
                Token newToken = new NumberToken(firstNumber.getNumber() * secondNumber.getNumber());
                tokensToReduce.remove(i);
                tokensToReduce.remove(i);
                tokensToReduce.remove(i);
                tokensToReduce.add(i, newToken);
            } else {
                i += 2;
            }

            if (i + 2 >= tokensToReduce.size()) {
                break;
            }
        }

        return tokensToReduce.get(0);
    }

    private void reduceBracket(int depth) {
        List<Token> tokens = new ArrayList<>();
        int startPosition = -1;
        boolean started = false;
        for (int i=0; i<this.tokenizedString.size();i ++) {
            Token token = this.tokenizedString.get(i);

            if (token instanceof OpenBracketToken && token.getDepth() == depth) {
                startPosition = i;
                started = true;
                continue;
            }

            if (token instanceof CloseBracketToken && token.getDepth() == depth) {
                started = false;
                break;
            }

            if (started) {
                tokens.add(token);
            }
        }
        int tokensToRemoveCount = tokens.size();
        Token replacementToken = this.reduce(tokens);
        this.tokenizedString.remove(startPosition); // remove start bracket
        for (int i = 0; i < tokensToRemoveCount; i++) {
            this.tokenizedString.remove(startPosition);
        }
        this.tokenizedString.remove(startPosition); // remove end bracket
        this.tokenizedString.add(startPosition, replacementToken);
        if (this.tokenizedString.stream().filter(a -> a instanceof OpenBracketToken).filter(a -> a.getDepth() == depth).count() > 0) {
            this.reduceBracket(depth);
        };
    }

    private int numberBrackets() {
        int depth = 0;
        int maxDepth = 0;
        for (Token eachToken : this.tokenizedString) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            if (eachToken instanceof OpenBracketToken) {
                depth++;
                eachToken.setDepth(depth);
            }
            if (eachToken instanceof CloseBracketToken) {
                eachToken.setDepth(depth);
                depth--;
            }
        }
        if (depth != 0) {
            throw new UnsupportedOperationException("Unbalanced braces");
        }

        return maxDepth;
    }
}
