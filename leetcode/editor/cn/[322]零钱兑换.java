import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        // 1.定义备忘录并初始化
        memo = new int[amount+1];
        Arrays.fill(memo, -666666);
        return dp(coins, amount);
    }
    public int dp(int[] coins, int n){
        // 2.base case
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;
        // 3.读取备忘录
        if (memo[n] != -666666)
            return memo[n];
        // 4.状态转移
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            // 计算子问题的结果
            int subProblem = dp(coins, n-coin);
            // 子问题无解则剪枝
            if (subProblem < 0)
                continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem+1);
        }
        // 5.写入备忘录
        res = (res == Integer.MAX_VALUE) ? -1 : res;
        memo[n] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
