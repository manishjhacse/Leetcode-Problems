class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] prefixDiffSum = new int[s.length() + 1];
        int Max = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            prefixDiffSum[i] = prefixDiffSum[i - 1] + Math.abs(s.charAt(i - 1) - t.charAt(i - 1));   // Stores sum of differences from beginning till i
            int start = 0;
            int end = i;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (prefixDiffSum[i] - prefixDiffSum[mid] <= maxCost) {
                    Max = Math.max(Max, i - mid);
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return Max;
    }
}