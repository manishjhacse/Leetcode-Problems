import java.util.ArrayList;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int maxOfMinofRows = Integer.MIN_VALUE;
        int n = matrix[0].length;
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[i][j]);

            }
            maxOfMinofRows = Math.max(min, maxOfMinofRows);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[j][i]);

            }
            if (max == maxOfMinofRows) {
                res.add(max);
                return res;
            }
        }

        return res;
    }
}