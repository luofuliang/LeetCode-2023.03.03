
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
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }
    /* 限定以 root 为根的⼦树节点必须满⾜ max.val > root.val > min.val */
    public boolean traverse(TreeNode root, TreeNode max, TreeNode min){
        // base case
        if (root == null){
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (max!=null && root.val>= max.val){
            return false;
        }
        if (min!=null && root.val<=min.val){
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return traverse(root.left, root, min) && traverse(root.right, max, root);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
