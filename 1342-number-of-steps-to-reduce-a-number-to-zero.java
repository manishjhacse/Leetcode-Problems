class Solution {
    public int helper(int n,int count){
        if(n==0)
        return count;
        if(n%2==0)
        return helper(n/2,count+1);
        else
        return helper(n-1,count+1);
    }
    public int numberOfSteps(int num) {
        // int count=0;
        // while (num!=0) {
        //     if(num%2==0)
        //     num=num/2;
        //     else
        //     num=num-1;
        //     count++;
        // }
        // return count;
        return helper(num,0);
    }
}