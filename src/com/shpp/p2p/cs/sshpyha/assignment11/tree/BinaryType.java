package com.shpp.p2p.cs.sshpyha.assignment11.tree;

public enum BinaryType {
    MULTIPLY {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() * rightNode.evaluate();
        }

        @Override
        public String getSign() {
            return " * ";
        }
    },
    DIVIDE {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() / rightNode.evaluate();
        }

        @Override
        public String getSign() {
            return " / ";
        }
    },
    MINUS {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() - rightNode.evaluate();
        }

        @Override
        public String getSign() {
            return " - ";
        }
    },
    POWER {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return Math.pow(leftNode.evaluate(), rightNode.evaluate());
        }

        @Override
        public String getSign() {
            return " ^ ";
        }
    },
    ADD {
        @Override
        public Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception {
            return leftNode.evaluate() + rightNode.evaluate();
        }

        @Override
        public String getSign() {
            return " + ";
        }
    };


    public abstract Double evaluate(TreeNode leftNode, TreeNode rightNode) throws Exception;

    public abstract String getSign();
}
