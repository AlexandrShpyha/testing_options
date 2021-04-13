package com.shpp.p2p.cs.sshpyha.assignment11;

import java.util.Arrays;

/**
 * Class that uses methods of calculator
 */
public class Assignment11Part1 {

    public static void main(String... args) {
        /*
         * Creating instance of calculator class
         */
        CalculatorPart2 calculator = new CalculatorPart2(Arrays.asList(args));
        /*
         * Calculating inputted expression
         */
        calculator.calculate();
    }
}
