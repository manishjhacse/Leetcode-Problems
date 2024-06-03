class Solution 
{
    public int appendCharacters(String s, String t) 
    {
        int p1 = 0, p2 = 0;
        int n1 = s.length(), n2 = t.length();
        while((p1 < n1) && (p2 < n2))
        {
            if(s.charAt(p1) == t.charAt(p2))
            {
                p2 ++;
            }
            p1 ++;
        }
        return n2-p2;
    }
}