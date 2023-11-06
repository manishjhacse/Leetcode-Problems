class Solution {
    public int maxProfit(int[] prices) {
       int minPrice=Integer.MAX_VALUE;
       int Profit=0;
       for(int i=0;i<prices.length;i++){
        minPrice=Math.min(minPrice, prices[i]);
        Profit=Math.max(Profit, prices[i]-minPrice);
       }
       return Profit;
    }
}