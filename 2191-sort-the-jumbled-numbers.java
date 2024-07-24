import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] newSystem(int[] mapping, int[] nums) {
        int n = nums.length;
        int newSystemArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 0) {
                newSystemArr[i] = mapping[0];
                continue;
            }
            int newNum = 0;
            int multiplier = 1;
            while (num > 0) {
                int digit = num % 10;
                num = num / 10;
                newNum = newNum + mapping[digit] * multiplier;
                multiplier *= 10;
            }
            newSystemArr[i] = newNum;
        }
        return newSystemArr;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int newSystemArr[] = newSystem(mapping, nums);
        Integer index[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return newSystemArr[a] - newSystemArr[b];
            }
        });
        int ans[] = new int[n];
        int i = 0;
        for (int ind : index) {
            ans[i++] = nums[ind];
        }
        return ans;
    }
}
