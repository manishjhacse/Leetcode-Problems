class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int length = ans.length();
            char ch = s.charAt(i);
            if (length > 0 && Math.abs(ans.charAt(length - 1) - ch) == 32) {
                ans.deleteCharAt(length - 1);
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}