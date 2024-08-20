class Solution {
    int n;
    int dp[][][] = new int[2][101][101];

    int forAlice(int piles[], int turn, int i, int M) {
        if (i >= n) {
            return 0;
        }
        if (dp[turn][i][M] != -1) {
            return dp[turn][i][M];
        }
        int result = turn == 1 ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];
            if (turn == 1) {
                result = Math.max(result, stones + forAlice(piles, 0, i + x, Math.max(M, x)));

            } else {
                result = Math.min(result, forAlice(piles, 1, i + x, Math.max(M, x)));

            }
        }
        return dp[turn][i][M] = result;
    }

    public int stoneGameII(int[] piles) {
        n = piles.length;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return forAlice(piles, 1, 0, 1);
    }
}