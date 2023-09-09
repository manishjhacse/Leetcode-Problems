import java.util.HashMap;

class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int val=map.get(nums[i]);
                map.put(nums[i], val+1);
            }
            else{
                map.put(nums[i],0);
            }
        }
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            if(e.getValue()==0){
                ans=ans+e.getKey();
            }
        }
        return ans;
    }
}