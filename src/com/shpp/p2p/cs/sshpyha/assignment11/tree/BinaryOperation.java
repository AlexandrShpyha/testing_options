package com.shpp.p2p.cs.sshpyha.assignment11.tree;

public class BinaryOperation implements  TreeNode {

    private final TreeNode leftNode;
    private final TreeNode rightNode;
    private final BinaryType type;

    public BinaryOperation(TreeNode leftNode, TreeNode rightNode, BinaryType type) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.type = type;
    }

    @Override
    public void print() {
        leftNode.print();
        System.out.print(type.getSign());
        rightNode.print();
    }

    @Override
    public Double evaluate() throws Exception {
        return type.evaluate(leftNode,rightNode);
    }
}
