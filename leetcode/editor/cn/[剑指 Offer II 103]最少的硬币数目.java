import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 迭代解法
    public int coinChange(int[] coins, int amount) {
        // 1.定义dp数组：amount为i时，需要dp[i]枚硬币凑成。
        int[] dp = new int[amount+1];
        // 2.dp数组初始化
        Arrays.fill(dp, amount+1);
        // 3.base case
        dp[0] = 0;
        // 4.状态转移
        // 4.1 遍历所有状态的所有取值
        for (int i = 1; i < amount + 1; i++) {
            // 4.2 遍历所有选择的所有取值
            for(int coin : coins){
                // 4.3 剪枝
                if (i-coin < 0)
                    continue;
                dp[i] = Math.min(dp[i-coin]+1, dp[i]);
            }
        }
        dp[amount] = (dp[amount] == amount+1) ? -1 : dp[amount];
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
