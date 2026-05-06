class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        var w = grid[0].length;
        var h = grid.length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(w, h , i, j ,grid);
                res = res + 1;
            }
        }

        return res;
    }

    void dfs(int w, int h, int i, int j, char[][] grid) {
        if (i < 0 || i >= h) {
            return;
        }
        if (j < 0 || j >= w) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(w, h, i + 1, j, grid);
        dfs(w, h, i - 1, j, grid);
        dfs(w, h, i, j + 1, grid);
        dfs(w, h, i, j - 1, grid);
    }
}
