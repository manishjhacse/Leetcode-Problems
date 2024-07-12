import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        int max, min;
        char first, second;
        if (x > y) {
            first = 'a';
            second = 'b';
            max = x;
            min = y;

        } else {
            first = 'b';
            second = 'a';
            max = y;
            min = x;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != second) {
                list1.add(s.charAt(i));
            } else {
                if (!list1.isEmpty() && list1.get(list1.size() - 1) == first) {
                    list1.remove(list1.size() - 1);
                    ans += max;
                } else {
                    list1.add(s.charAt(i));
                }
            }

        }
        while (!list1.isEmpty()) {
            char ch = list1.remove(list1.size() - 1);
            if (ch != second) {
                list2.add(ch);
            } else {
                if (!list2.isEmpty() && list2.get(list2.size() - 1) == first) {
                    list2.remove(list2.size() - 1);
                    ans += min;
                } else {
                    list2.add(ch);
                }
            }
        }

        return ans;

    }
}