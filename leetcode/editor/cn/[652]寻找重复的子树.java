
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
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> map = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }
    public String traverse(TreeNode root){
        if (root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        int sum = map.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (sum == 1){
            res.add(root);
        }
        // 给子树对应的出现次数加一
        map.put(subTree, sum+1);
        return subTree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
