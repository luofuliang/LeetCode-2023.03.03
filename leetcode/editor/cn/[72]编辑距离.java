
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length()-1, n = word2.length()-1;
        memo = new int[m+1][n+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, m, word2, n);
    }
    // 定义：s1[0..i] 和 s2[0..j] 的最⼩编辑距离是 dp(s1, i, s2, j)
    public int dp(String s1, int m, String s2, int n){
        // base case
        if (m == -1)  return n+1;
        if (n == -1)  return m+1;

        if (memo[m][n] != 0)
            return memo[m][n];
        // 状态转移
        if (s1.charAt(m) == s2.charAt(n)){
            memo[m][n] = dp(s1, m-1, s2, n-1);
        } else {
            memo[m][n] = 1 + min(
                    dp(s1, m-1, s2, n),       // 删除
                    dp(s1, m, s2, n-1),        // 插入
                    dp(s1, m-1, s2, n-1)    // 替换
            );
        }
        return memo[m][n];
    }
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
