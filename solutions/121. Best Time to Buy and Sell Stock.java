class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;
        int sell=0;
        int profit=0;
        for(int i=1;i<prices.length;i++){
           if(prices[i]<prices[buy]){
               
               buy=i;
           }
           else{
              profit=prices[i]-prices[buy]>profit?prices[i]-prices[buy]:profit;
           } 
        }
        return profit;
    }
   
}
