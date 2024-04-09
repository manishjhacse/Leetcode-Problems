class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        // while(tickets[k]!=0)
        // for(int i=0;i<tickets.length;i++){
        //     if(tickets[k]==0){
        //         return time;
        //     }else if(tickets[i]>0){
        //         tickets[i]--;
        //         time++;
        //     }
        // }
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]<tickets[k]){
                time+=tickets[i];
            }else{
                if(i<=k)
                time+=tickets[k];
                else
                time+=tickets[k]-1;
            }
        }
        return time;
    }
}