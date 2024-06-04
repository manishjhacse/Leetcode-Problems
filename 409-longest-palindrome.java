class Solution {
    public int longestPalindrome(String s) {
        int arr[]=new int[128];
        int length=0;
        int oddCount=0;
        for(char ch:s.toCharArray()){
            if(arr[ch]!=0){
                length+=2;
                arr[ch]=0;
                oddCount--;
            }else{
                arr[ch]=1;
                oddCount++;
            }
        }
        return oddCount>0?length+1:length;
    }
}