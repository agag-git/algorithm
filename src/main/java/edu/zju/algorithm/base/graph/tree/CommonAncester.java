package edu.zju.algorithm.base.graph.tree;

import edu.zju.algorithm.util.TreeNode;

/**
 * �����������
 */
public class CommonAncester {

    private TreeNode res;

    /**
     * ����������ڵ� - ����1���ݹ鷨
     * @param root ���ĸ�
     * @param node1 Ŀ��ڵ�1
     * @param node2 Ŀ��ڵ�2
     * @return �� root Ϊ�������У�node1 �� node2 ������������ڵ�
     */
    public TreeNode leastCommonAncester(TreeNode root, TreeNode node1, TreeNode node2) {
        dfs(root, node1, node2);
        return res;
    }

    /**
     * �ݹ������ root Ϊ���������У�����Ŀ��㣨node1��node2��������
     * @param root
     * @param node1
     * @param node2
     * @return �� root Ϊ���������У�����Ŀ��㣨node1��node2�������������� -1 ��ʾ�����������ҵ�����������ڵ�
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
