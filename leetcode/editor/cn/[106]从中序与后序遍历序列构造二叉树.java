
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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return bulid(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode bulid(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd){
        // base case
        if (poStart > poEnd)
            return null;
        // 找出根节点
        int nodeVal = postorder[poEnd];
        int index = map.get(nodeVal);
        // 构造根节点
        TreeNode root = new TreeNode(nodeVal);
        // 递归构造左右子树
        // 左子树的节点数
        int leftSum = index - inStart;
        root.left = bulid(inorder, inStart, index-1, postorder, poStart, poStart+leftSum-1);
        root.right = bulid(inorder, index+1, inEnd, postorder, poStart+leftSum, poEnd-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
