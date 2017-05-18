package edu.zju.algorithm.base.graph.tree;

import edu.zju.algorithm.util.TreeNode;

/**
 * �����·
 */
public class LongestPath {

    private int length;

    /**
     * �����·�� - �и��������ڵ���ֻ���ӽڵ����ã�
     * @param root
     * @return
     */
    public int longestPath1(TreeNode root) {
        dfs(root);
        return length;
    }

    /**
     * �ݹ�����Ըõ�Ϊ����������������
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
     * �����·�� - �޸�����ͼ��
     * ����1�����ҵ�������ڵ���Զ�ĵ㣬���Ըõ�Ϊ�������е�����Ҷ�ӽڵ㣬��Ҷ�ӽڵ�Ϊ�·����һ���˵㣬�ٴӸö˵�������ҵ������·����Ϊ�·����
     */
}
