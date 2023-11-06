import java.util.HashMap;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        HashMap<Character,Integer> jew=new HashMap<>();
        for(int i=0;i<jewels.length();i++)
        {
            char ch=jewels.charAt(i);
            jew.put(ch,0);
        }
        for(int i=0;i<stones.length();i++)
        {
            char ch=stones.charAt(i);
            if(jew.containsKey(ch))
            {
                count++;
            }
        }
        return count;
    }
}