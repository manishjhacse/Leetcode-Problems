class Pair {
    int ele;
    int list;
    int pos;

    Pair(int a, int b, int c) {
        ele = a;
        list = b;
        pos = c;
    }
}

class Solution {
    void compare(int ans[],int c,int d)
    {
        long a=ans[0];
        long b=ans[1];
        if(b-a <= d-c)return;
        ans[0]=c;
        ans[1]=d;
        return;
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.ele-b.ele);
        int ans[] ={Integer.MIN_VALUE,Integer.MAX_VALUE};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int e = nums.get(i).get(0);
            if (e > max)
                max = e;
            pq.add(new Pair(e, i, 0)); 
        }

        while (!pq.isEmpty()) {
            Pair curr = pq.peek();
            pq.remove();
            int ele = curr.ele;
            int list = curr.list;
            int pos = curr.pos;
           if(pos==nums.get(list).size()-1)
           {
               compare(ans,ele,max);
               return ans;
           }
            compare(ans,ele,max);
            if (max < nums.get(list).get(pos + 1))
                max = nums.get(list).get(pos + 1);
            pq.add(new Pair(nums.get(list).get(pos + 1), list, pos + 1));

        }
       return new int[2];
    }
}