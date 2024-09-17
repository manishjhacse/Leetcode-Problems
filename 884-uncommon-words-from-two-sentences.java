import java.security.KeyStore.Entry;
import java.util.HashMap;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;
        int start = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ' ' || i == s1.length() - 1) {
                int last = i == s1.length() - 1 ? i + 1 : i;
                String word = s1.substring(start, last);
                start=i+1;
                if (map.containsKey(word)) {
                    if (map.get(word)) {
                        map.put(word, false);
                        count--;
                    }
                } else {
                    map.put(word, true);
                    count++;
                }
            }
        }
        start = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == ' ' || i == s2.length() - 1) {
                int last = i == s2.length() - 1 ? i + 1 : i;
                String word = s2.substring(start, last);
                start=i+1;
                if (map.containsKey(word)) {
                    if (map.get(word)) {
                        map.put(word, false);
                        count--;
                    }
                } else {
                    map.put(word, true);
                    count++;
                }
            }
        }
        String ans[] = new String[count];
        int index = 0;
        for (Map.Entry<String, Boolean> set : map.entrySet()) {
            if (set.getValue()) {
                ans[index++] = set.getKey();
            }
        }
        return ans;
    }
}