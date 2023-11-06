class Solution {
    public int bulbSwitch(int n) {

       int on_bulb=0;
       for(int i=1;i<=n;i++)
       {
        if(i*i<=n)
        {
            on_bulb++;
        }
        else{
            break;
        }
       } 
       return on_bulb;
    }
}