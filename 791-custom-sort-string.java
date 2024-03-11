class Solution {
    public String customSortString(String order, String s) {
        int freq[] = new int[26];
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < order.length(); i++) {
            if (freq[order.charAt(i) - 'a'] > 0) {
                while (freq[order.charAt(i) - 'a']-- > 0) {
                    ans.append(order.charAt(i));
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                while (freq[i]-- > 0) {
                    ans.append((char) (i + 'a'));
                }
            }
        }
        return ans.toString();
    }
}