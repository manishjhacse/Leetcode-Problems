import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        // HashMap<Integer,Integer>freqMap=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        // freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        // }
        // int maxCount=0;
        // int maxFreq=0;
        // for(Map.Entry<Integer, Integer> e : freqMap.entrySet()){
        // int freq=e.getValue();
        // if(freq>maxFreq){
        // maxFreq=freq;
        // maxCount=freq;
        // }else if(freq==maxFreq){
        // maxCount+=freq;
        // }
        // }
        // return maxCount;
        int freq[] = new int[101];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        int maxCount = 0;
        int maxFreq = 0;
        for (int i = 1; i < 101; i++) {
            int freqCount = freq[i];
            if (freqCount > maxFreq) {
                maxFreq = freqCount;
                maxCount = freqCount;
            } else if (freqCount == maxFreq) {
                maxCount += freqCount;
            }
        }
        return maxCount;
    }
}