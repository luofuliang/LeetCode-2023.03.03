
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 未想到最优解时，一个dfs1用于把靠边的岛屿沉掉，另一个dfs负责计数
    // 注意复制时，检查！检查!检查!
    int sum = 0;
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs1(grid, i, 0);
            if (grid[i][n-1] == 1) dfs1(grid, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) dfs1(grid, 0, j);
            if (grid[m-1][j] ==1) dfs1(grid, m-1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    dfs(grid, i, j);
                }
            }
        }
        return sum;
    }
    public void dfs1(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n) return;
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs1(grid, i-1, j);
        dfs1(grid, i+1, j);
        dfs1(grid, i, j-1);
        dfs1(grid, i, j+1);
    }
    public void dfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if (i<0 || j<0 || i>=m || j>=n) return;
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        sum++;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
