
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 如果岛屿 B 中存在一片陆地，在岛屿 A 的对应位置是海水，那么岛屿 B 就不是岛屿 A 的子岛，将其淹没！
    int sum = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1){
                    // 这个岛屿肯定不是子岛，淹没
                    dfs(grid2, i, j);
                }
            }
        }
        // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1){
                    sum++;
                    dfs(grid2, i, j);
                }
            }
        }
        return sum;
    }
    public void dfs(int[][] g, int i, int j){
        int m = g.length, n = g[0].length;
        if (i<0 || j<0 || i>=m || j>=n) return;
        if (g[i][j] == 0) return;

        g[i][j] = 0;
        dfs(g, i-1, j);
        dfs(g, i+1, j);
        dfs(g, i, j-1);
        dfs(g, i, j+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
