package edu.zju.algorithm.base.graph.tree;

import edu.zju.algorithm.util.TreeNode;

/**
 * 最近公共祖先
 */
public class CommonAncester {

    private TreeNode res;

    /**
     * 最近公共父节点 - 方法1：递归法
     * @param root 树的根
     * @param node1 目标节点1
     * @param node2 目标节点2
     * @return 以 root 为根的树中，node1 和 node2 的最近公共父节点
     */
    public TreeNode leastCommonAncester(TreeNode root, TreeNode node1, TreeNode node2) {
        dfs(root, node1, node2);
        return res;
    }

    /**
     * 递归计算以 root 为根的子树中，包含目标点（node1、node2）的数量
     * @param root
     * @param node1
     * @param node2
     * @return 以 root 为根的子树中，包含目标点（node1、node2）的数量，返回 -1 表示该子树中已找到最近公共父节点
     */
    private int dfs(TreeNode root, TreeNode node1, TreeNode node2) {
        int leftNum = 0;
        int rightNum = 0;
        int currNum = (root == node1 || root == node2) ? 1 : 0;
        if (root.left != null) {
            leftNum = dfs(root.left, node1, node2);
            if (leftNum == -1) {
                return -1;
            }
        }
        if (root.right != null) {
            rightNum = dfs(root.right, node1, node2);
            if (rightNum == -1) {
                return -1;
            }
        }
        int total = leftNum + rightNum + currNum;
        if (total == 2) {
            res = root;
            return -1;
        } else {
            return total;
        }
    }
}
