class Solution {
    int memo[] = new int[50001];

    public int getIndex(int jobs[][], int l, int currentJobEnd) {
        int r = jobs.length - 1;
        int result = jobs.length + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (jobs[mid][0] >= currentJobEnd) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public int solve(int jobs[][], int i) {
        if (i >= jobs.length)
            return 0;
        if (memo[i] != -1)
            return memo[i];
        int next = getIndex(jobs, i + 1, jobs[i][1]);
        int taken = jobs[i][2] + solve(jobs, next);
        int notTaken = solve(jobs, i + 1);
        return memo[i] = Math.max(taken, notTaken);

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Arrays.fill(memo, -1);
        int job[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            job[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(job, (a, b) -> a[0] - b[0]);
        return solve(job, 0);

    }
}