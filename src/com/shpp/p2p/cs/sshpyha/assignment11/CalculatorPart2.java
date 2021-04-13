package com.shpp.p2p.cs.sshpyha.assignment11;

import com.shpp.p2p.cs.sshpyha.assignment11.tree.TreeNode;

import java.util.*;

import static java.lang.System.exit;

/**
 * Class that calculates arithmetical expressions
 */
public class CalculatorPart2 {
    /**
     * Fields that represent formula and constants values
     */
    private String formula;
    private final List<String> constants = new ArrayList<>();
    private Map<String, Double> constantValues = new HashMap<>();
    /**
     * Fields that saves link to arithmetical tree root
     */
    private TreeNode treeRoot;

    /**
     * Initializes arguments from program input and parses formula and constants
     *
     * @param arguments list with formula and arguments values
     */
    CalculatorPart2(List<String> arguments) {
        Parser parser = new Parser();
        initializeArgs(arguments);
        try {
            treeRoot = parser.parseFormula(formula);
            constantValues = parser.parseVariables(constants);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            exit(0);
        }
    }

    /**
     * Prints parsed formula and evaluates it
     */
    public void calculate() {
//        System.out.println(constantValues);
        treeRoot.print();
        try {
            System.out.println(" = " + treeRoot.evaluate());
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    /**
     * Iterates over list of arguments and separate formula and variables values
     *
     * @param arguments list that contains all arguments
     */
    private void initializeArgs(List<String> arguments) {
        Iterator<String> iterator = arguments.iterator();
        if (iterator.hasNext())
            formula = iterator.next();
        while (iterator.hasNext())
            constants.add(iterator.next());
    }
}
