class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int i:arr){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(freqMap.values());
        while(k>0){
            k-=pq.poll();
        }
        return k<0?pq.size()+1:pq.size();
    }
}