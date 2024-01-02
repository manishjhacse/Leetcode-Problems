import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int freq[] = new int[nums.length + 1];
        for (int num : nums) {
            if (freq[num] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            int index = freq[num];
            ans.get(index).add(num);
            freq[num]++;
        }
        return ans;

    }
}