import java.util.HashMap;

class Solution {
    public int minSteps(String s, String t) {
        int ans=0;
        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        //     map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        // }
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() > 0) {
        //         ans += entry.getValue();
        //     }
        // }
        int characters[]=new int[26];
        for(int i=0;i<s.length();i++){
            characters[s.charAt(i)-'a']++;
            characters[t.charAt(i)-'a']--;
        }
        for(int num:characters){
            if(num>0){
                ans+=num;
            }
        }

        return ans;
    }
}