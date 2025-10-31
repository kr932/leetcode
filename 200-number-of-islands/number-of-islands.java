public class Solution {
    private int rows, cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        rows = grid.length;
        cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // Boundary and visited check
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') return;

        grid[i][j] = '0'; // mark as visited (sink the island)
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    // Optional: local test
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(sol.numIslands(grid1)); // Output: 1

        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(sol.numIslands(grid2)); // Output: 3
    }
}
