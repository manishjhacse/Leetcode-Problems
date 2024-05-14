class Solution {
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];
        int totalGold = 0;
        int maximumGold = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                totalGold += grid[i][j];
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    maximumGold = Math.max(maximumGold, dfs(grid, visited, i, j));
                    if (maximumGold == totalGold) {
                        return maximumGold;
                    }

                }

            }
        }
        return maximumGold;

    }

    public int dfs(int grid[][], boolean visited[][], int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0
                || visited[row][col]) {
            return 0;
        }
        int maximumGold = 0;
        visited[row][col] = true;
        maximumGold = Math.max(maximumGold, dfs(grid, visited, row - 1, col));
        maximumGold = Math.max(maximumGold, dfs(grid, visited, row + 1, col));
        maximumGold = Math.max(maximumGold, dfs(grid, visited, row, col + 1));
        maximumGold = Math.max(maximumGold, dfs(grid, visited, row, col - 1));
        visited[row][col] = false;
        return grid[row][col] + maximumGold;
    }
}