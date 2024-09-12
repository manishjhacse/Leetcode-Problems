import java.util.HashSet;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int arr[]=new int[26];
        int consistent = 0;
        for (char c : allowed.toCharArray()) {
            arr[c-'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (char c : words[i].toCharArray()) {
                if (arr[c-'a']==0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                consistent++;
            }
        }
        return consistent;
    }
}