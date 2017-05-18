package edu.zju.algorithm.base.graph.tree;

import edu.zju.algorithm.util.TreeNode;

/**
 * 树上最长路
 */
public class LongestPath {

    private int length;

    /**
     * 树上最长路径 - 有根树（树节点中只有子节点引用）
     * @param root
     * @return
     */
    public int longestPath1(TreeNode root) {
        dfs(root);
        return length;
    }

    /**
     * 递归计算以该点为根的子树的最大深度
     * @param node
     * @return
     */
    private int dfs(TreeNode node) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (node.left != null) {
            leftDepth = dfs(node.left);
        }
        if (node.right != null) {
            rightDepth = dfs(node.right);
        }
        int maxDepth = Math.max(leftDepth, rightDepth) + 1;
        int maxLenth = leftDepth + rightDepth + 1;
        if (maxLenth > length) {
            length = maxLenth;
        }
        return maxDepth;
    }

    /**
     * 树上最长路径 - 无根树（图）
     * 方法1：先找到离给定节点最远的点，即以该点为根的树中的最深叶子节点，该叶子节点为最长路径的一个端点，再从该端点出发，找到最深的路径即为最长路径。
     */
}
