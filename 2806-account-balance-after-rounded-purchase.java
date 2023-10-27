class Solution {
    public int accountBalanceAfterPurchase(int amt) {
        if(amt%10 == 0)
        {
            return 100-amt;
        }
        int ans=100-amt;
        return amt%10 >= 5 ? (ans/10)*10 : ((ans/10)+1)*10;
    }
}