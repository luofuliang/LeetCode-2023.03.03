
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();
        return bulid(1, n);
    }
    /* 构造闭区间 [lo, hi] 组成的 BST */
    public List<TreeNode> bulid(int low, int high){
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (low > high){
            res.add(null);
            return res;
        }
        // 1、穷举 root 节点的所有可能。
        for (int i = low; i <= high; i++) {
            // 2、穷举左右子树的所有可能
            List<TreeNode> leftTree = bulid(low, i-1);
            List<TreeNode> rightTree = bulid(i+1, high);
            // 3、拼接可能的生成树
            for(TreeNode left : leftTree){
                for(TreeNode right : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
