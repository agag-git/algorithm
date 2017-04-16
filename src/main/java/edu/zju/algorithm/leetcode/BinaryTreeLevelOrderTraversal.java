package edu.zju.algorithm.leetcode;

import edu.zju.algorithm.leetcode.util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> level = new ArrayList<>();
//        LinkedList<TreeNode> queue1 = new LinkedList<>();
//        LinkedList<TreeNode> queue2 = new LinkedList<>();
//        TreeNode current;
//        if (root != null){
//            queue1.offer(root);
//            while (!queue1.isEmpty() || !queue2.isEmpty()){
//                if (!queue1.isEmpty()){
//                    while (!queue1.isEmpty()){
//                        current = queue1.poll();
//                        level.add(current.val);
//                        if (current.left != null)
//                            queue2.offer(current.left);
//                        if (current.right != null)
//                            queue2.offer(current.right);
//                    }
//                    list.add(level);
//                    level = new ArrayList<>();
//                }
//                if (!queue2.isEmpty()){
//                    while (!queue2.isEmpty()){
//                        current = queue2.poll();
//                        level.add(current.val);
//                        if (current.left != null)
//                            queue1.offer(current.left);
//                        if (current.right != null)
//                            queue1.offer(current.right);
//                    }
//                    list.add(level);
//                    level = new ArrayList<>();
//                }
//            }
//        }
//        return list;
//    }
    List<ArrayList<Object>> list = new ArrayList<>();
    public List<ArrayList<Object>> levelOrder(TreeNode root) {
        addList(root, 0);
        return list;
    }

    public void addList(TreeNode root, int level){
        if (root != null){
            if (list.size() <= level)
                list.add(new ArrayList<>());
            list.get(level).add(root.val);
            addList(root.left, level+1);
            addList(root.right, level+1);
        }
    }

    public static void main(String[] args){

    }
}
