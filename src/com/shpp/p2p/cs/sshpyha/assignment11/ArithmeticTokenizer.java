package com.shpp.p2p.cs.sshpyha.assignment11;

import com.shpp.p2p.cs.sshpyha.assignment11.tree.FunctionList;

/**
 * Class that breaks strings with formula and variables into tokens
 */
public final class ArithmeticTokenizer {

    private static ArithmeticTokenizer instance;

    private ArithmeticTokenizer() {
    }

    /**
     * Creating only one instance of tokenizer
     *
     * @return tokenizer instance
     */
    public static ArithmeticTokenizer getInstance() {
        if (instance == null) {
            instance = new ArithmeticTokenizer();
        }
        return instance;
    }

    /**
     * Deleting all spaces in formula, replaces unary minuses and add spaces near all binary operands
     *
     * @param formula string that contains formula
     * @return returns array of string tokens
     */
    public String[] getTokensFromFormula(String formula) {
        formula = formula.replaceAll("\\s", "");
        formula = replaceUnaryMinuses(formula);
        formula = formatFormula(formula);
        return formula.split(" ");
    }

    /**
     * Get tokens from string
     *
     * @param variableValue string that contains variable and its value
     * @return returns array of string tokens
     */
    public String[] getTokensFromVariable(String variableValue) {
        variableValue = variableValue.replaceAll("\\s", "");
        return variableValue.split("=");
    }

    /**
     * Adding spaces near all binary operands
     *
     * @param formula string that contains formula
     * @return returns formatted string
     */
    private String formatFormula(String formula) {
        formula = formula.replaceAll("\\+", " + ");
        formula = formula.replaceAll("-", " - ");
        formula = formula.replaceAll("\\*", " * ");
        formula = formula.replaceAll("/", " / ");
        formula = formula.replaceAll("\\^", " ^ ");
        formula = formula.replaceAll("\\(", " ( ");
        formula = formula.replaceAll("# \\(", "#( ");
        formula = formula.replaceAll("\\)", " ) ");
        formula = formula.replaceAll("  ", " ");
        if (formula.charAt(0) == ' ') {
            formula = formula.substring(1);
        }
        return formula;
    }

    /**
     * Replaces all unary minuses
     *
     * @param formula string that contains formula
     * @return returns modified string
     */
    private String replaceUnaryMinuses(String formula) {
        formula = formula.replaceAll("^-", "#");
        char[] chars = formula.toCharArray();
        StringBuilder result = new StringBuilder();
        result.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!Character.isLetterOrDigit(chars[i - 1]) && chars[i] == '-') {
                chars[i] = '#';
            }
            result.append(chars[i]);
        }
        return result.toString();
    }

}
