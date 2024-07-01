class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveCount=0;
        for(int num:arr){
            if(num%2==1){
                consecutiveCount++;
            }else{
                consecutiveCount=0;
            }
            if(consecutiveCount==3){
                return true;
            }
        }
        return false;
    }
}