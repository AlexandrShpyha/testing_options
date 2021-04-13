package com.shpp.p2p.cs.sshpyha.assignment11.tree;

/**
 * Class that represent number
 */
public class Number implements TreeNode {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate() {
        return this.value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
