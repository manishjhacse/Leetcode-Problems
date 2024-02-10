class Solution {
    private int solveMemo(String s, int i, int j, int[][] dp) {
       if (i >= j)
           return 1;

       if (dp[i][j] >= 0)
           return dp[i][j];

       return dp[i][j] = s.charAt(i) == s.charAt(j) ? solveMemo(s, i + 1, j - 1, dp) : 0;
   }
   public int countSubstrings(String s) {
         int[][] dp = new int[s.length()][s.length()];
       for (int[] d : dp) {
           Arrays.fill(d, -1);
       }

       int count = 0;
       for (int i = 0; i < s.length(); i++) {
           for (int j = i; j < s.length(); j++) {
               count += solveMemo(s, i, j, dp);
           }
       }

       return count;
   }
}