class Solution {
    public String restoreString(String s, int[] arr) {
        char ans [] = new char[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            ans[arr[i]] = s.charAt(i);
        }
        return new String(ans);
    }
}