class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            int num1=s.charAt(i);
            int num2=s.charAt(i+1);
            ans+=Math.abs(num1-num2);
        }
        return ans;
    }
}