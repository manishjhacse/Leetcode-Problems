import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String getFrequency(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder freqString = new StringBuilder("");
        char c = 'a';
        for (int i : freq) {
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        return freqString.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> freqStringMap = new HashMap<>();
        for (String s : strs) {
            String freq = getFrequency(s);
            if (freqStringMap.containsKey(freq)) {
                freqStringMap.get(freq).add(s);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(s);
                freqStringMap.put(freq, strList);
            }
        }
        return new ArrayList<>(freqStringMap.values());

    }
}