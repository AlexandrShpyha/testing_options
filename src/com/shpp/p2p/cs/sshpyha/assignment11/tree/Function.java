package com.shpp.p2p.cs.sshpyha.assignment11.tree;

/**
 * Tree node that represents function
 */
public class Function implements TreeNode {
    private final TreeNode nextNode;
    private final FunctionList functionType;

    public Function(TreeNode nextNode, FunctionList functionType) {
        this.nextNode = nextNode;
        this.functionType = functionType;
    }

    @Override
    public Double evaluate() throws Exception {
        return functionType.evaluate(nextNode);
    }
}
