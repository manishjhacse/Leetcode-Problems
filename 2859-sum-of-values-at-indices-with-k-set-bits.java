class Solution {
    public int countKbits(int i)
    {
        int count=0;
        while(i>0){
                count+=i&1;
                i>>=1;

            }
            return count;

    }



    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum=0;

        for(int i=0;i<nums.size();i++){
            int count=0;
            int ind=i;
            count= countKbits(i);
            
            if(count==k){
                sum+=nums.get(i);
            }
        }
        return sum;


        
    }
}