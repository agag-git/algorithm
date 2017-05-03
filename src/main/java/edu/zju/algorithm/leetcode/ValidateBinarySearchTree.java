package edu.zju.algorithm.leetcode;

import edu.zju.algorithm.util.TreeNode;

public class ValidateBinarySearchTree {
    private int lastMin = Integer.MIN_VALUE;
    private boolean first = true;
    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }

    public boolean inorderTraversal(TreeNode root){
        if (root == null)
            return true;
        if (inorderTraversal(root.left)){
            if (first) {
                lastMin = root.val;
                first = false;
            }
            else {
                if (root.val <= lastMin)
                    return false;
                else
                    lastMin = root.val;
            }
            return inorderTraversal(root.right);
        }
        return false;
    }
}