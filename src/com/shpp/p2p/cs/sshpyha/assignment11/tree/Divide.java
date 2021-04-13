package com.shpp.p2p.cs.sshpyha.assignment11.tree;

/**
 * Class that represent division operation
 */
public class Divide implements TreeNode {
    private final TreeNode leftNode;
    private final TreeNode rightNode;

    public Divide(TreeNode leftNode, TreeNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public Double eval() throws Exception {
        return leftNode.eval() / rightNode.eval();
    }

    @Override
    public void print() {
        leftNode.print();
        System.out.print(" / ");
        rightNode.print();
    }
}
