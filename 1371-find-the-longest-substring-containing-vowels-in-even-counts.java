import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTheLongestSubstring(String s) {
        int xor = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                xor ^= ch;
            }
            if (map.containsKey(xor)) {
                ans = Math.max(ans, i - map.get(xor));
            } else {
                map.put(xor, i);
            }
        }
        return ans;
    }
}