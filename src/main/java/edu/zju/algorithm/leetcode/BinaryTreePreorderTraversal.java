package edu.zju.algorithm.leetcode;

import edu.zju.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null){
            list.add(root.val);
            if (root.left != null)
                for (Integer integer : preorderTraversal(root.left))
                    list.add(integer);
            if (root.right != null)
                for (Integer integer : preorderTraversal(root.right))
                    list.add(integer);
        }
        return list;
    }
}


