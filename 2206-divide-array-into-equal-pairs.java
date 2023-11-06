class Solution {
    public boolean divideArray(int[] nums) {
        int temp[] = new int[1000];
        for(int i : nums) temp[i]++;
        for(int i=0; i<temp.length; i++){
            if(temp[i]%2!=0) return false;
        }
        return true;

    }
}