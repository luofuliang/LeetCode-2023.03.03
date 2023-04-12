
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String SEP = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    /* 主函数，将二叉树序列化为字符串 */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    /* 辅助函数，将二叉树存入 StringBuilder */
    public void serialize(TreeNode root, StringBuilder sb){
        // 先序遍历
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    public TreeNode deserialize(String data) {
        // 将字符串转化为链表
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    /* 辅助函数，通过 nodes 列表构造二叉树 */
    public TreeNode deserialize(LinkedList<String> nodes) {
        // base case
        if (nodes.isEmpty())
            return null;
        // preOrder
        String s = nodes.pollFirst();
        if (s.equals(NULL))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
