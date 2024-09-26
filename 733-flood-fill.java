class Solution {
    int totalRow, totalCol;

    void dfs(int row, int col, int newColor, int currColor, int image[][]) {
        if (row < 0 || col < 0 || row >= totalRow || col >= totalCol) {
            return;
        }
        if (image[row][col] != currColor || image[row][col] == newColor) {
            return;
        }
        image[row][col] = newColor;
        int adjList[][] = {
                { row - 1, col }, { row, col + 1 }, { row + 1, col }, { row, col - 1 }
        };
        for (int neighbor[] : adjList) {
            int newRow = neighbor[0];
            int newCol = neighbor[1];
            dfs(newRow, newCol, newColor, currColor, image);
        }

    }

    public void bfs(int row, int col, int newColor, int currColor, int image[][]) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col });
        image[row][col] = newColor;
        while (!queue.isEmpty()) {
            int node[] = queue.poll();
            row = node[0];
            col = node[1];
            int adjList[][] = { { row - 1, col }, { row, col + 1 }, { row + 1, col }, { row, col - 1 } };

            for (int neighbor[] : adjList) {
                int newRow = neighbor[0];
                int newCol = neighbor[1];
                if (newRow < 0 || newCol < 0 || newRow >= totalRow || newCol >= totalCol) {
                    continue;
                }
                if (image[newRow][newCol] != currColor || image[newRow][newCol] == newColor) {
                    continue;
                }
                queue.offer(new int[] { newRow, newCol });
                image[newRow][newCol] = newColor;
            }

        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        totalRow = image.length;
        totalCol = image[0].length;
        // bfs(sr, sc, color, image[sr][sc], image);
        dfs(sr, sc, color, image[sr][sc], image);
        return image;

    }
}