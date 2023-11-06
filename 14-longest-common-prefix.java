import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result=new StringBuilder();
        Arrays.sort(strs);
        for(int i=0;i<strs[0].length();i++){
            if(strs[0].charAt(i)!=strs[strs.length-1].charAt(i))
            break;
            result.append(strs[0].charAt(i));
        }
        return result.toString();
       
    }
}