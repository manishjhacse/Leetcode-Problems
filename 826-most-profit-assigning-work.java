class Solution {
    int maxValue(int difficulty[]) {
        int max = Integer.MIN_VALUE;
        for (int num : difficulty) {
            if (num > max)
                max = num;
        }
        return max;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        int jobs[] = new int[maxValue(difficulty) + 1];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
        }
        for (int i = 1; i < jobs.length; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }
        for (int i = 0; i < worker.length; i++) {
            if (worker[i] >= jobs.length) {
                maxProfit += jobs[jobs.length - 1];
            } else {
                maxProfit += jobs[worker[i]];
            }
        }
        return maxProfit;
    }
}