package com.shpp.p2p.cs.sshpyha.assignment11;

import com.shpp.p2p.cs.sshpyha.assignment11.exceptions.BracesException;
import com.shpp.p2p.cs.sshpyha.assignment11.tree.*;
import com.shpp.p2p.cs.sshpyha.assignment11.tree.Number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that parses tokens into arithmetical tree and variables values into hash map
 * Tree is build using recursive descent parses method
 */
public class Parser {
    /**
     * Fields that saves reference to tokenizer class, array of string tokens,
     * hash map with constants and pointer to position in array of string tokens
     */
    private final ArithmeticTokenizer tokenizer;
    private String[] tokens;
    private final Map<String, Double> constants = new HashMap<>();
    private int pos = 0;

    /**
     * Instantiate tokenizer reference
     */
    public Parser() {
        tokenizer = ArithmeticTokenizer.getInstance();
    }

    /**
     * Parses formula from tokens into arithmetical tree
     *
     * @param formula string that contains formula
     * @return returns reference to root node
     */
    public TreeNode parseFormula(String formula) {
        tokens = tokenizer.getTokensFromFormula(formula);
        System.out.println(Arrays.toString(tokens));
        for (String token : tokens) {
            if (token.charAt(0) == '#') {
                System.out.print("-" + token.substring(1) + " ");
            } else System.out.print(token + " ");
        }
        return parseExpression();
    }

    /**
     * Parses expression es sequence of terms
     *
     * @return returns reference to root node
     */
    public TreeNode parseExpression() {
        TreeNode first = parseTerm();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (operator.equals("+")) {
                pos++;
                TreeNode second = parseTerm();
                first = new BinaryOperation(first, second, BinaryType.ADD);
            } else if (operator.equals("-")) {
                pos++;
                TreeNode second = parseTerm();
                first = new BinaryOperation(first, second, BinaryType.MINUS);
            } else break;
        }
        return first;
    }

    /**
     * Parses term es sequence of exponent factors
     *
     * @return returns reference to term node
     */
    public TreeNode parseTerm(){
        TreeNode first = parseExpFactor();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (operator.equals("*")) {
                pos++;
                TreeNode second = parseExpFactor();
                first = new BinaryOperation(first, second, BinaryType.MULTIPLY);
            } else if (operator.equals("/")) {
                pos++;
                TreeNode second = parseExpFactor();
                first = new BinaryOperation(first, second, BinaryType.DIVIDE);
            } else break;
        }
        return first;
    }

    /**
     * Parses exponent factor es sequence of simple factors
     *
     * @return returns reference to exponent factor node
     */
    public TreeNode parseExpFactor() {
        TreeNode first = parseFactor();

        if (pos < tokens.length) {
            String operator = tokens[pos];
            if (operator.equals("(")){
                System.out.println("Bad parenthesis");
                System.exit(1);
            }
            if (operator.equals("^")) {
                pos++;
                TreeNode second = parseExpFactor();
                return new BinaryOperation(first, second, BinaryType.POWER);
            }
        }
        return first;
    }

    /**
     * Parses factor, if it has minus before it, gets rid of it
     *
     * @return returns reference to exponent factor node
     */
    public TreeNode parseFactor() {
        try {
            String nextToken = tokens[pos];
            if (nextToken.charAt(0) == '#' && nextToken.length() > 1) {
                return new Negate(createNode(nextToken.substring(1)));
            }
            return createNode(nextToken);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad expression ending");
            System.exit(1);
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }

    /**
     * Creates different nodes types from token
     *
     * @param nextToken token to be parsed
     * @return returns created tree node
     * @throws Exception
     */
    private TreeNode createNode(String nextToken) throws Exception {
        pos++;
        if (nextToken.equals("(")) {
            TreeNode node = parseExpression();
            if (pos < tokens.length && tokens[pos].equals(")")) {
                pos++;
                return node;
            } else throw new BracesException("Something bad with parenthesis");
        } else if (isFunction(nextToken)) {
            return new Function(createNode(tokens[pos]), FunctionList.valueOf(nextToken));
        } else if (Character.isDigit(nextToken.charAt(0))) {
            return new Number(Double.parseDouble(nextToken));
        } else if (Character.isLetter(nextToken.charAt(0))) {
            return new Variable(nextToken, constants);
        } else if (nextToken.equals(")")) {
            throw new BracesException("Something bad with parenthesis");
        } else {
            throw new Exception("Wrong operand at position: " + pos);
        }
    }

    /**
     * Cheching whether token is function name or not
     *
     * @param nextToken token to be checked
     * @return returns boolean value
     */
    private boolean isFunction(String nextToken) {
        try {
            FunctionList.valueOf(nextToken);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Parses variables into hash map with names and values
     *
     * @param variables list that contains variables
     * @return hash map of variables and their values
     * @throws Exception throws exceptions that can be thrown when parsing variables
     */
    public Map<String, Double> parseVariables(List<String> variables) throws Exception {
        String[] variableValue;
        for (String variable : variables) {
            variableValue = tokenizer.getTokensFromVariable(variable);
            try {
                if (variableValue.length == 2) {
                    if (!constants.containsKey(variableValue[0])) {
                        constants.put(variableValue[0], Double.parseDouble(variableValue[1]));
                    } else throw new Exception("You put several values of variable: " + variableValue[0]);
                } else throw new Exception("You input variable in incorrect format: " + Arrays.toString(variableValue));
            } catch (NumberFormatException e) {
                throw new Exception("Variable value is incorrect: " + variableValue[1]);
            }
        }
        return constants;
    }
}
