package com.shpp.p2p.cs.sshpyha.assignment11.tree;

/**
 * Enum that defines binary operators method evaluate
 */
public enum BinaryType {
    MULTIPLY {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() * rightNode.evaluate();
        }
    },
    DIVIDE {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() / rightNode.evaluate();
        }
    },
    MINUS {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() - rightNode.evaluate();
        }
    },
    POWER {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return Math.pow(leftNode.evaluate(), rightNode.evaluate());
        }
    },
    ADD {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() + rightNode.evaluate();
        }
    };


    public abstract Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception;

}
