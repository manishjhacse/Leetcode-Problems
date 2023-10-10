class Solution {
    public static boolean isPossible(int[] weights, int capacity, int daysWithin) {
        int days = 1, load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                days = days + 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        if (days <= daysWithin)
            return true;
        else
            return false;

    }

    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0], high = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > low) {
                low = weights[i];
            }
            high += weights[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}