class Solution {
    public int maxRowIndex(int mat[][], int col) {
        int maxIndex = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > mat[maxIndex][col])
                maxIndex = i;
        }
        return maxIndex;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans[] = { -1, -1 };
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxIndex = maxRowIndex(mat, mid);
            int left = mid - 1 >= 0 ? mat[maxIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxIndex][mid + 1] : -1;
            if (mat[maxIndex][mid] > left && mat[maxIndex][mid] > right) {
                ans[0] = maxIndex;
                ans[1] = mid;
                return ans;
            } else if (mat[maxIndex][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }
}