
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        // base case
        if (n == 0 || n == 1){
            return n;
        }
        // 压缩空间
        int dp_i_1 = 1, dp_i_2 =0;
        int dp_i = 0;
        for (int i = 2; i <= n; i++) {
            dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;    // dp_i_2先更新
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
