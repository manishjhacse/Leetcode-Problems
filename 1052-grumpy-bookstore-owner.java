class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalSatisfied = 0;
        int maxIncrease = 0;
        
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        
        int increase = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                increase += customers[i];
            }
            if (i >= minutes && grumpy[i - minutes] == 1) {
                increase -= customers[i - minutes];
            }
            maxIncrease = Math.max(maxIncrease, increase);
        }
        
        return totalSatisfied + maxIncrease;
    }
}