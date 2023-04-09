
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int max_area = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                sum = dfs(grid, i, j);
                max_area = Math.max(max_area, sum);
            }
        }
        return max_area;
    }
    // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地⾯积
    public int dfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n) return 0;
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;

        return dfs(grid, i-1, j) +
                dfs(grid, i+1, j) +
                dfs(grid, i, j-1) +
                dfs(grid, i, j+1) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
