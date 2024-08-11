class Solution {
    int[][] dirs = {{ -1, 0 },{ 0, 1 },{ 1, 0 },{ 0, -1 }};
    int rows;
    int cols;
    static boolean hasArticulationPoint;
    static int time;
    
    public int minDays(int[][] grid) {
        rows = grid.length; 
        cols = grid[0].length;
        hasArticulationPoint = false;
        time = 0;
        int landCells = 0, islandCount = 0;

        int[][] discoveryTime = new int[rows][cols];
        int[][] lowestReachable = new int[rows][cols];
        int[][] parentCell = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(discoveryTime[i], -1);
            Arrays.fill(lowestReachable[i], -1);
            Arrays.fill(parentCell[i], -1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    landCells++;
                    if (discoveryTime[i][j] == -1) {
                        findArticulationPoints(grid, i, j, discoveryTime, lowestReachable, parentCell);
                        islandCount++;
                    }
                }
            }
        }

        if (islandCount == 0 || islandCount >= 2) return 0;
        if (landCells == 1) return 1;
        if (hasArticulationPoint) return 1;
        return 2;
    }

    private void findArticulationPoints(int[][] grid, int row, int col, int[][] discoveryTime, int[][] lowestReachable, int[][] parentCell) {
        discoveryTime[row][col] = time;
        time++;
        lowestReachable[row][col] = discoveryTime[row][col];
        int children = 0;
        
        for (int[] direction : dirs) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (!isCellValid(grid, newRow, newCol)) {
                continue;
            }
            if (discoveryTime[newRow][newCol] == -1) {
                children++;
                parentCell[newRow][newCol] = row * cols + col;
                findArticulationPoints(grid, newRow, newCol, discoveryTime, lowestReachable, parentCell);
                lowestReachable[row][col] = Math.min(lowestReachable[row][col], lowestReachable[newRow][newCol]);

                if (lowestReachable[newRow][newCol] >= discoveryTime[row][col] && parentCell[row][col] != -1) {
                    hasArticulationPoint = true;
                }
            } else if (newRow * cols + newCol != parentCell[row][col]) {
                lowestReachable[row][col] = Math.min(lowestReachable[row][col], discoveryTime[newRow][newCol]);
            }
        }

        if (parentCell[row][col] == -1 && children > 1) {
            hasArticulationPoint = true;
        }
    }

    private boolean isCellValid(int[][] grid, int row, int col) {
        return (row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] == 1);
    }
}
