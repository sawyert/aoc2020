package com.tim.aoc2020.day18;

import java.util.ArrayList;
import java.util.List;

public class TokenizedString {
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


        while (tokensToReduce.size() > 1) {
            NumberToken firstNumber = (NumberToken) tokensToReduce.get(0);
            Token sign = tokensToReduce.get(1);
            NumberToken secondNumber = (NumberToken) tokensToReduce.get(2);

            if (sign instanceof MultiplyToken) {
                Token newToken = new NumberToken(firstNumber.getNumber() * secondNumber.getNumber());
                tokensToReduce.remove(0);
                tokensToReduce.remove(0);
                tokensToReduce.remove(0);
                tokensToReduce.add(0, newToken);
            }
            else if (sign instanceof AddToken) {
                Token newToken = new NumberToken(firstNumber.getNumber() + secondNumber.getNumber());
                tokensToReduce.remove(0);
                tokensToReduce.remove(0);
                tokensToReduce.remove(0);
                tokensToReduce.add(0, newToken);
            }
            else {
                throw new UnsupportedOperationException(("Don't know what to do with a " + sign.getClass().getName()));
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
