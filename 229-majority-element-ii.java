import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                count1 = 1;
                ele1 = nums[i];
            } else if (count2 == 0 && nums[i] != ele1) {
                count2 = 1;
                ele2 = nums[i];
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) {
                count1++;
            }
            if (nums[i] == ele2) {
                count2++;
            }
        }
        int min = nums.length / 3 + 1;
        if (count1 >= min) {
            ans.add(ele1);
        }
        if (count2 >= min) {
            ans.add(ele2);
        }
        return ans;
    }
}