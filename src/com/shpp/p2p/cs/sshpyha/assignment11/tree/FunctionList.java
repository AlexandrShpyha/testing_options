package com.shpp.p2p.cs.sshpyha.assignment11.tree;

/**
 * Enum that defines function method evaluate
 */
public enum FunctionList {
    sin {
        @Override
        public Double evaluate(TreeNode node) throws Exception {
            return Math.sin(node.evaluate());
        }
    },
    cos {
        @Override
        public Double evaluate(TreeNode node) throws Exception {
            return Math.cos(node.evaluate());
        }
    },
    tan {
        @Override
        public Double evaluate(TreeNode node) throws Exception {
            return Math.tan(node.evaluate());
        }
    },
    atan {
        @Override
        public Double evaluate(TreeNode node) throws Exception {
            return Math.atan(node.evaluate());
        }
    },
    log10 {
        @Override
        public Double evaluate(TreeNode node) throws Exception {
            return Math.log10(node.evaluate());
        }
    },
    log2 {
        @Override
        public Double evaluate(TreeNode node) throws Exception {
            return Math.log(node.evaluate()) / Math.log(2);
        }
    },
    sqrt {
        @Override
        public Double evaluate(TreeNode node) throws Exception {
            return Math.sqrt(node.evaluate());
        }
    };

    public abstract Double evaluate(TreeNode node) throws Exception;
}
