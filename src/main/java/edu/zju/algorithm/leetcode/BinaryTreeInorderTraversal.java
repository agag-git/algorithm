package edu.zju.algorithm.leetcode;

import edu.zju.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return list;
    }
    public void recursion(TreeNode root){
        if (root != null){
            recursion(root.left);
            list.add(root.val);
            recursion(root.right);
        }
    }
}
