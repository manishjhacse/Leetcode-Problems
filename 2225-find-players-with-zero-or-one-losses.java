class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> zeroLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0) + 0);
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 0) {
                zeroLost.add(i);
            } else if (map.get(i) == 1) {
                oneLost.add(i);
            }
        }
        Collections.sort(zeroLost);
        Collections.sort(oneLost);
        return Arrays.asList(zeroLost, oneLost);
    }
}