
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    // 层次遍历
    List<Integer> list = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        levelTraverse(root);
        return list;
    }
    public void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int num = q.size();
            int value = Integer.MIN_VALUE;
            for (int i = 0; i < num; i++) {
                TreeNode node = q.poll();
                value = Math.max(value, node.val);
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            list.add(value);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)












