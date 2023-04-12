
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return bulidTree(nums, 0, nums.length-1);
    }

    /* 定义：将 nums[start..end] 构造成符合条件的树，返回根节点 */
    public TreeNode bulidTree(int[] nums, int start, int end){
        // base case
        if (start > end) return null;

        // 找最大值
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue){
                maxValue = nums[i];
                index = i;
            }
        }
        // 先序遍历
        TreeNode root = new TreeNode(maxValue);
        root.left = bulidTree(nums, start, index-1);
        root.right = bulidTree(nums, index+1, end);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
