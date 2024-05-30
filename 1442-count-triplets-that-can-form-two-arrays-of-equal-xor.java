class Solution {
    public int countTriplets(int[] arr) {
        HashMap<Integer, Integer> d = new HashMap<>();
        int ans = 0;
        
        for (int j = 1; j < arr.length; j++) {
            d.clear();
            int xor = 0;
            for (int i = j - 1; i >= 0; i--) {
                xor ^= arr[i];
                d.put(xor, d.getOrDefault(xor, 0) + 1);
            }
        
            xor = 0;
            for (int i = j; i < arr.length; i++) {
                xor ^= arr[i];
                if (d.containsKey(xor)) {
                    ans += d.get(xor);
                }
            }
        }
        return ans;
    }
}