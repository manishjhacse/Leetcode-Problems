import java.util.HashSet;

class Solution {
    int dp[];

    public int solve(int i, int n, String s, HashSet<String> set) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int res = 1 + solve(i + 1, n, s, set);
        for (int j = i; j < n; j++) {
            String curr = s.substring(i, j + 1);
            if (set.contains(curr)) {
                res = Math.min(res, solve(j + 1, n, s, set));
            }
        }
        dp[i] = res;
        return res;
    }

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        HashSet<String> set = new HashSet<>();
        for (String str : dictionary) {
            set.add(str);
        }

        return solve(0, n, s, set);
    }
}