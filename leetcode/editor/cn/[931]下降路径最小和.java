import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;
    int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n+1][n+1];
        // 备忘录里的值初始化为不可能取到的值。
        // Arrays.fill只能对一维数组今天填充。要先正确的实现二维数组的填充，就需要我们循环进行赋值
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 999);
        }

        // 终点可能在最后⼀⾏的任意⼀列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }
    int dp(int[][] matrix, int i, int j) {
        // 1、⾮法索引检查
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            // 返回⼀个特殊值
            return 99999;
        }
        // 2、base case
        if (i == 0) {
            return matrix[i][j];
        }
        // 3、查找备忘录，防止重复计算
        if (memo[i][j] != 999)
            return memo[i][j];
        // 4、状态转移
        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j + 1)
        );
        return memo[i][j];
    }
    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
