package com.shpp.p2p.cs.sshpyha.assignment11.tree;

import java.util.Map;

/**
 * Class that represent variable
 */
public class Variable implements TreeNode {

    private final String name;
    private final Map<String, Double> constants;

    public Variable(String name, Map<String, Double> constants) {
        this.name = name;
        this.constants = constants;
    }

    @Override
    public Double evaluate() throws Exception {
        Double value = constants.get(name);
        if (value != null) {
            return value;
        } else throw new Exception("There is no value for variable: " + name);
    }

    @Override
    public void print() {
        System.out.print(name);
    }
}
