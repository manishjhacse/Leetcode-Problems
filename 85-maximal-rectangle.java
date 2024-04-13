class Solution {
    public int maximalRectangle(char[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[][] heights = new int[numRows][numCols];
        int maxArea = -1;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                heights[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(heights[i][j] == 1 && i > 0)
                    heights[i][j] += heights[i - 1][j];
            }
        }
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                int currentHeight = heights[i][j];
                int[] currentRow = heights[i];
                int leftWidth = getLeftCount(numCols, i, j, currentRow, currentHeight);
                int rightWidth = getRightCount(numCols, i, j, currentRow, currentHeight);
                int totalWidth = leftWidth + rightWidth + 1;
                int area = heights[i][j] * totalWidth;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static int getLeftCount(int numCols, int rowIndex, int colIndex, int[] row, int height) {
        int count = -1;
        while(colIndex >= 0 && row[colIndex] >= height) {
            count++;
            colIndex--;
        }
        if(count == -1)
            return 0;
        return count;
    }

    public static int getRightCount(int numCols, int rowIndex, int colIndex, int[] row, int height) {
        int count = -1;
        while(colIndex < numCols && row[colIndex] >= height) {
            count++;
            colIndex++;
        }
        if(count == -1)
            return 0;
        return count;
    }
}
