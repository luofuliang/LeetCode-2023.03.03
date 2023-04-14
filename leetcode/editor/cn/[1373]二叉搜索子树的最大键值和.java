
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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        if (root == null)
            return maxSum;
        traverse(root);
        return maxSum;
    }
    /*
    traverse(root) 返回⼀个⼤⼩为 4 的 int 数组，我们暂且称它为 res，其中：
    res[0] 记录以 root 为根的⼆叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
    res[1] 记录以 root 为根的⼆叉树所有节点中的最⼩值；
    res[2] 记录以 root 为根的⼆叉树所有节点中的最⼤值；
    res[3] 记录以 root 为根的⼆叉树所有节点值之和。
     */
    public int[] traverse(TreeNode root){
        // base case
        if (root == null){
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        /*******后序遍历位置*******/
        // 判断左右子树是否是BST
        int[] res = new int[4];
        if (left[0]==1 && right[0]==1 && root.val>left[2] && root.val<right[1]){
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);   // 左子树可能为空，所以要加入根节点进行比较
            res[2] = Math.max(right[2], root.val);
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        }else{
            res[0] = 0;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
