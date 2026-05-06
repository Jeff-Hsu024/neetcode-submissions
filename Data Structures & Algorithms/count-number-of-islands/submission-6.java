class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(i, j, grid);
                res = res + 1;
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;
        if (i < 0 || i >= rows) {
            return;
        }
        if (j < 0 || j >= cols) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}
