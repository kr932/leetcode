class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        // Traverse every city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++; // After finishing DFS for one province
            }
        }

        return count;
    }

    // Depth-First Search
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
