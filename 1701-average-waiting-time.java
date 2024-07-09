class Solution {
    public double averageWaitingTime(int[][] customers) {
        int idleTime = 1;
        long totalWaitingTime = 0;
        for (int i = 0; i < customers.length; i++) {
            if (idleTime <= customers[i][0]) {
                idleTime = customers[i][0] + customers[i][1];
            } else {
                idleTime += customers[i][1];
            }
            totalWaitingTime += (idleTime - customers[i][0]);
        }
        return totalWaitingTime / (double) customers.length;
    }
}