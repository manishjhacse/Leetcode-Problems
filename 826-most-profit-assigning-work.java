class Solution {
    private int maxDifficulty(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxValue = maxDifficulty(difficulty);
        int jobs[] = new int[maxValue + 1];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
        }
        for (int i = 1; i < jobs.length; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }
        int maxProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            if (worker[i] > maxValue) {
                maxProfit += jobs[maxValue];
            } else {
                maxProfit += jobs[worker[i]];
            }
        }
        return maxProfit;

    }
}