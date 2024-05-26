class Solution {
    private final int MOD = 1000000007;
    public int checkRecord(int n) {
        int[][][] memo = new int[n+1][3][2];
        for(int[][] d: memo){
            for(int[] row: d) Arrays.fill(row, -1);
        }
        return solve(n, 0, 0, memo);
    }

    private int solve(int n, int consecutiveLates, int absents, int[][][] memo){
        if(absents >= 2 || consecutiveLates >= 3) return 0;
        if(n == 0) return 1;


        if(memo[n][consecutiveLates][absents] != -1) return memo[n][consecutiveLates][absents];
        int ans = 0;
        // choose A for current position
        ans = (solve(n-1, 0, absents+1, memo)) % MOD;

        // choose L for current position
        ans = (ans + solve(n-1, consecutiveLates+1, absents, memo)) % MOD;

        // choose P for current position
        ans = (ans + solve(n-1, 0, absents, memo)) % MOD;

        return memo[n][consecutiveLates][absents] = ans;
    }
}