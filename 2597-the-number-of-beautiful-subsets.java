import java.util.HashMap;

class Solution {
    public int totalSubsets(int[] nums, int k, int index, HashMap<Integer, Integer> freqMap) {
        if (index == nums.length) {
            if (freqMap.size() == 0)
                return 0;
            else
                return 1;

        }
        int pick = 0;
        int num1 = nums[index] + k;
        int num2 = nums[index] - k;

        if (freqMap.size() == 0 || (!freqMap.containsKey(num1) && !freqMap.containsKey(num2))) {
            freqMap.put(nums[index], freqMap.getOrDefault(nums[index], 0) + 1);
            pick = totalSubsets(nums, k, index + 1, freqMap);
            freqMap.put(nums[index], freqMap.get(nums[index]) - 1);
            if (freqMap.get(nums[index]) == 0) {
                freqMap.remove(nums[index]);
            }
        }
        int noPick = totalSubsets(nums, k, index + 1, freqMap);
        return pick + noPick;
    }

    public int beautifulSubsets(int[] nums, int k) {
        return totalSubsets(nums, k, 0, new HashMap<>());
    }
}