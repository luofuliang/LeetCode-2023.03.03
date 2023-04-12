
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 定义：输⼊节点 root，然后 root 为根的⼆叉树就会被拉平为⼀条链表
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;
        // 先递归拉平左右子树
        flatten(root.left);
        flatten(root.right);

        // 后序遍历位置
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null){    // 此处必须为p.right不能为p，否则会发生空指针异常。
            p = p.right;
        }
        p.right = right;    // 我们要的是p不为空，才能对p.right进行连接
    }
}
//leetcode submit region end(Prohibit modification and deletion)
