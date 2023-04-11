
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
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /*
    定义：前序遍历数组为 preorder[preStart..preEnd]，
    中序遍历数组为 inorder[inStart..inEnd]，
    构造这个二叉树并返回该二叉树的根节点
    */
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        // base case
        if (preStart > preEnd)
            return null;
        int nodeVal = preorder[preStart];
        // 找根节点在inorder中的位置
        int index = map.get(nodeVal);
        TreeNode root = new TreeNode(nodeVal);
        // 左子树的节点数
        int leftSum = index - inStart;
        // 递归的构造左右子树
        root.left = build(preorder, preStart+1, preStart+leftSum, inorder, inStart, index-1);
        root.right = build(preorder, preStart+leftSum+1, preEnd, inorder, index+1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
