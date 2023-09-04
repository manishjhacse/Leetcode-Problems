import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res[]=new int[2];
        int len=nums.length;
        for(int i=0;i<len;i++)
        {
            hm.put(nums[i],i);
        }

        for(int i=0;i<len;i++)
        {
            if(nums[i]==target && hm.containsKey(0))
            {
                res[0]=i;
                res[i]=hm.get(0);
                break;
            }
            else if(hm.containsKey(target-nums[i]))
            {
                if(hm.get(target-nums[i])>i)
                {
                    res[0]=i;
                    res[1]=hm.get(target-nums[i]);
                    break;
                }
            }

        }
        return res;
    }
}