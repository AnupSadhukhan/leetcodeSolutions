class Solution {
    public int change(int amount, int[] coins) {
        // create an array of amount+1
        // e.g. amount 5, coins 1, 2, 5
        // dp : [0,0,0,0,0,0];
        // set index 0 as 1 bcz if for amount 0 we will always get one possibilies like , we will not give not amount :)
        // now for each denomination we will check dp[current amount]-denomination we have selected, we will add up values 
        // at that index's to current index i.e to current amount
        // denomination =1 , dp=[1,1,1,1,1,1]
        // denomination = 2, dp=[1,1,2,2,3,3]
        // denomination = 5, dp=[1,1,2,2,3,4]
        // return dp[amount] means last index.
        
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                     dp[j]+=dp[j-coins[i]];
            }
           
        }
        return dp[amount];
    }
}
