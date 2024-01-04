import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        // Create a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        // put nums[i] as key and freq as value in tha map
        for (int num : nums) {
            if (map.containsKey(num)) {
                int val = map.get(num) + 1;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }
        // iterate the hashmap
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int freq = e.getValue();
            // if val freq is 1 return -1
            if (freq == 1) {
                return -1;
            } else {
                // if freq is divisible by 3 we will add freq/3 in the ans
                if (freq % 3 == 0) {
                    ans += (freq / 3);
                }
                // if rem=1 or 2 that mean it will be divided by 2 also so add freq/3 +1
                else if (freq % 3 == 1 || freq % 3 == 2) {
                    ans += (freq / 3) + 1;
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}