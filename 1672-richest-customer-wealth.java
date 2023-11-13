class Solution {
    public int maximumWealth(int[][] accounts) {
        int largest = accounts[0][0];
        for(int customer[] : accounts){
            int currentSum = 0;
            for(int bank : customer) currentSum += bank;
            largest = Math.max(largest, currentSum);
        }
        return largest;
    }
}