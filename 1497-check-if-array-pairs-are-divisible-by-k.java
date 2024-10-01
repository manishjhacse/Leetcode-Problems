class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderFrequencyMap = new HashMap<>();
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            remainderFrequencyMap.put(remainder, remainderFrequencyMap.getOrDefault(remainder, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : remainderFrequencyMap.entrySet()) {
            int remainder = entry.getKey();
            int remainderFreq = entry.getValue();
            if (remainder == 0) {
                if (remainderFreq % 2 != 0)
                    return false;
            } else {
                int complementRemainder = k - remainder;
                int complementFreq = remainderFrequencyMap.getOrDefault(complementRemainder, 0);
                if (remainderFreq != complementFreq) {
                    return false;
                }
            }
        }
        return true;

    }
}