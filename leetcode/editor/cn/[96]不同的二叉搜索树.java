
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return count(1, n);
    }
    /*
    定义：返回从low到high的闭区间，可以产生的BST种数。
     */
    public int count(int low, int high){
        int res = 0;
        // base case
        if (low  high)
            return 1;
        if (memo[low][high] != 0){
            return memo[low][high];
        }
        // 以i为根节点
        for (int i = low; i <= high; i++) {
            int left = count(low, i-1);
            int right = count(i+1, high);
            res += left*right;
        }
        memo[low][high] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
