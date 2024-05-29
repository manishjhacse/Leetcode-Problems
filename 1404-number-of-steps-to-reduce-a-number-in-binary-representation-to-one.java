class Solution {
    public int numSteps(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        while (sb.length() > 1) {
            ans++;
            if (sb.charAt(0) == '1') {
                int i = 0;
                while (i < sb.length() && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i++;
                }
                if (i == sb.length()) {
                    sb.append('1');
                } else {
                    sb.setCharAt(i, '1');
                }
            } else {
                sb.deleteCharAt(0);
            }
        }

        return ans;
    }
}
