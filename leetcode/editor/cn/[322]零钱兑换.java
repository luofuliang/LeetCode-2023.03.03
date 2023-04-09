import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 1; i <= amount; i++) {
            // 内层 for 循环在求所有选择的最⼩值
            for( int coin : coins){
                // ⼦问题⽆解，跳过
                if (i-coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
