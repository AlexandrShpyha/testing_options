package com.shpp.p2p.cs.sshpyha.assignment11.tree;

/**
 * Class that represents binary operation
 */
public class BinaryOperation implements TreeNode {

    private final TreeNode leftNode;
    private final TreeNode rightNode;
    private final BinaryType type;

    public BinaryOperation(TreeNode leftNode, TreeNode rightNode, BinaryType type) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.type = type;
    }

    @Override
    public Double evaluate() throws Exception {
        return type.evaluate(leftNode, rightNode);
    }
}
