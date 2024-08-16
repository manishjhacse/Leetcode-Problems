class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size() - 1);
            res = Math.max(res, Math.max(max - minValue, maxValue - min));
            minValue = Math.min(minValue, min);
            maxValue = Math.max(maxValue, max);
        }

        return res;
    }
}