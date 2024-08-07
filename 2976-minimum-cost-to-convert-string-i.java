public class Solution {
    public long minimumCost(String src, String tar, char[] ori, char[] chan, int[] cost) {
        int n = ori.length;
        int m = src.length();
        long[][] dp = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < 26; i++) {
            dp[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[ori[i] - 'a'][chan[i] - 'a'] = Math.min(dp[ori[i] - 'a'][chan[i] - 'a'], (long) cost[i]);
        }
        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dp[i][via] != Long.MAX_VALUE && dp[via][j] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][via] + dp[via][j]);
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            if (dp[src.charAt(i) - 'a'][tar.charAt(i) - 'a'] == Long.MAX_VALUE) {
                return -1;
            }
            ans += dp[src.charAt(i) - 'a'][tar.charAt(i) - 'a'];
        }
        return ans;
    }
}
