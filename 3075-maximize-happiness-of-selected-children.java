class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long maxSum = 0;
        int step = 0;
        int index = happiness.length - 1;
        while (step < k) {
            maxSum += Math.max(happiness[index--] - step++, 0);
        }
        return maxSum;
    }
}