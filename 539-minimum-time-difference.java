import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        boolean timeDiff[] = new boolean[1440];
        for (int i = 0; i < n; i++) {
            String s = timePoints.get(i);
            int h = Integer.parseInt(s.substring(0, 2));
            int m = Integer.parseInt(s.substring(3));
            int min = h * 60 + m;
            if (timeDiff[min]) {
                return 0;
            } else {
                timeDiff[min] = true;
            }
        }
        int prev = -1;
        int firstVal = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < timeDiff.length; i++) {
            if (timeDiff[i]) {
                if (prev == -1) {
                    prev = i;
                    firstVal = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                    prev = i;
                }
            }
        }
        if (prev != -1) {
            minDiff = Math.min(minDiff, 1440 + firstVal - prev);
        }
        return minDiff;
    }
}