class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        PriorityQueue<ArrayList<Integer>> pq=new PriorityQueue<>(new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> al1,ArrayList<Integer> al2){
                    return al1.get(0).compareTo(al2.get(0));
            }
        });
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int val:hand){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        for(Integer i1:hm.keySet()){
            pq.offer(new ArrayList<Integer>(Arrays.asList(i1,hm.get(i1))));
        } 
        while(pq.size()>0){
            ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
              ArrayList<Integer> al=pq.poll();
              temp.add(al);
            int c=1;
            int prev=al.get(0);
            while(c<groupSize){
                if(pq.size()==0) return false;
                ArrayList<Integer> dup=pq.poll();
                if(prev+1!=dup.get(0)){
                    return false;
                }
                else{
                    temp.add(dup);
                    prev=dup.get(0);
                }
              c++;
            }
            for(ArrayList<Integer> pl:temp){
                if(pl.get(1)==1){
                    continue;
                }
                pq.offer(new ArrayList<Integer>(Arrays.asList(pl.get(0),pl.get(1)-1)));
            }
        }
        return true;
    }
}