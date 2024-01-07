import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer>[] map = new Map[len];
        for (int i = 0; i < len; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - (long) nums[j];
                if (d <= Integer.MIN_VALUE || d >= Integer.MAX_VALUE)
                    continue;
                int n1 = map[j].getOrDefault((int) d, 0);
                int n2 = map[i].getOrDefault((int) d, 0);
                ans += n1;
                int freq = n1 + n2 + 1;
                map[i].put((int) d, freq);
            }
        }
        return ans;
    }
}