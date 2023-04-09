
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
    // 返回左子树的最大长度+右子树的最大长度
    int max_length = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max_length;
    }
    public void traverse(TreeNode root){
        if(root == null)
            return;

        int l = MaxDepth(root.left);
        int r = MaxDepth(root.right);
        max_length = Math.max(l + r, max_length);

        traverse(root.left);
        traverse(root.right);

    }
    public int MaxDepth(TreeNode root){
        if(root == null)
            return 0;
        int l = MaxDepth(root.left);
        int r = MaxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
