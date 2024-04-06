class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        int openParentheses = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openParentheses++;
                ans.append(ch);
            } else if (ch == ')') {
                if (openParentheses > 0) {
                    ans.append(ch);
                    openParentheses--;
                }
            } else {
                ans.append(ch);
            }
        }

        for (int i = ans.length() - 1; i >= 0; i--) {
            if (openParentheses == 0) {
                break;
            }
            if (ans.charAt(i) == '(') {
                ans.deleteCharAt(i);
                openParentheses--;
            }
        }
        return ans.toString();
    }

}