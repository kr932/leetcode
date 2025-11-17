class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Push all initially rotten oranges to queue
        // Count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges, answer is 0
        if (fresh == 0) return 0;

        int minutes = -1;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // Step 2: BFS level-by-level (multi-source BFS)
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                // 4-directional spreading
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;      // Fresh → Rotten
                        fresh--;              // Reduce fresh count
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // If still fresh oranges left → impossible
        return fresh == 0 ? minutes : -1;
    }
}
