import java.util.ArrayList;

class Solution {
    static ArrayList<String> returnCombination(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        int start = (digit - 2) * 3;
        if (digit > 7)
            start = start + 1;
        int end = (digit - 1) * 3;
        if (digit == 7 || digit == 8)
            end = end + 1;
        if (digit == 9)
            end = end + 2;
        ArrayList<String> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            list.addAll(returnCombination(p + ch, up.substring(1)));
        }
        return list;
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (!digits.isEmpty())
            ans = returnCombination("", digits);

        return ans;

    }
}