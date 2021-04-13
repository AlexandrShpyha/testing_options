package com.shpp.p2p.cs.sshpyha.assignment11.tree;

/**
 * Class that represent negate operation
 */
public class Negate implements TreeNode {
    private final TreeNode nextNode;

    public Negate(TreeNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public Double eval() throws Exception {
        return nextNode.eval() * (-1);
    }

    @Override
    public void print() {
        System.out.print("-");
        nextNode.print();
    }
}
