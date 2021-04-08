class Solution {
    public int maxProfit(int[] prices) {
        int day10=0; // day1 with 0 stock in hand 1st transation
        int day11=Integer.MIN_VALUE; // day1 with 1 stock in hand 1st transation
        int day20=0; // day2 with 0 stock in hand 2nd transation
        int day21=Integer.MIN_VALUE; // day1 with 1 stock in hand 2nd transation
        for(int price : prices){
            day20=Math.max(day20,day21+price);
            day21=Math.max(day21,day10-price);
            day10=Math.max(day10,day11+price);
            day11=Math.max(day11, -price);
        }
        return day20;
    }
}
