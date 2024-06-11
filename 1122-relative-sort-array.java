class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[arr1.length];
        int index = 0;

        for (int num : arr2) {
            if (freqMap.containsKey(num)) {
                int count = freqMap.get(num);
                for (int i = 0; i < count; i++) {
                    result[index++] = num;
                }
                freqMap.remove(num);
            }
        }

        List<Integer> remaining = new ArrayList<>(freqMap.keySet());
        Collections.sort(remaining);
        for (int num : remaining) {
            int count = freqMap.get(num);
            while (count > 0) {
                result[index++] = num;
                count--;
            }
        }

        return result;
    }
}