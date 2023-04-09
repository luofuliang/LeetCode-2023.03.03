
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 压缩空间
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // 若只使用前 i 个物品（可以重复使用），当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包。
        int[] dp = new int[amount+1];
        // base case
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j-coins[i-1] >= 0){ // 边界：等于
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
