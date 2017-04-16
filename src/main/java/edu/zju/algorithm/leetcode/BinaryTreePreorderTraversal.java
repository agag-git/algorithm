import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/9/11.
 */

//Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

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
