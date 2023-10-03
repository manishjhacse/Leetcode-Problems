class Solution {
    public int calculateTime(int piles[], int h) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += Math.ceil((double) piles[i] / (double) h);
        }
        return time;
    }

    public static int findMax(int piles[]) {
        int high = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > high)
                high = piles[i];
        }
        return high;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = calculateTime(piles, mid);
            if (h >= hours) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}