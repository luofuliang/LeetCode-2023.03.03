
//leetcode submit region begin(Prohibit modification and deletion)

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minD = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            // 遍历当前层的节点
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null)
                    return minD;
                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
            }
            // 一层遍历完，深度加一；如果下面没有节点，在上面就会返回了。
            minD++;
        }
        return minD;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
