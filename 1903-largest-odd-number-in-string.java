class Solution {
    public String largestOddNumber(String num) {
        String ans="";
        int len=num.length();
        for(int i=len-1;i>=0;i--){
            if((int)num.charAt(i)%2!=0){
                ans=ans+num.substring(0, i+1);
                break;
            }
        }
        return ans;
    }
}