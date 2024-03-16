class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(sum,-1);
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum--;
            }else{
                sum++;
            }
            if(map.containsKey(sum)){
                maxLength=Math.max(maxLength,i-map.get(sum));
            }else{
            map.put(sum,i);
            }

        }
        return maxLength;
    }
}