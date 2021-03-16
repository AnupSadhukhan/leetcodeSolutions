class Solution {
    public int maxProfit(int[] prices, int fee) {
      int sell=0;
      int buy=-prices[0]-fee;
        for(int i=1;i<prices.length;i++){
            int tmp=sell;
            sell=Math.max(sell,buy+prices[i]);
            buy=Math.max(buy,tmp-prices[i]-fee);
        }
        return sell;
    }
}
