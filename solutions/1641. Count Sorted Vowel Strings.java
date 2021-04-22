class Solution {
    // DFS + Memorization O(n) 0ms
    // we will run  recursive call and inside recursinve call we will use for loop which will run i to 4
    // to make the  string which is lexigraphically sorted, 000 (accept), 010(not accept) because
    // 0 is coming after 1, so it is not lexigraphically sorted. We have used 0,1,2,3,4 insted of a,e,i,o,u
   /* int[][] dp;
    public int countVowelStrings(int n) {
        dp=new int[n][5];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int count=0;
        for(int j=0;j<5;j++){
            count+=helper(n-1,j);
        }
        return count;
    }
    public int helper(int n,int i){
        if(n==0) return 1;
        if(dp[n-1][i]!=-1) return dp[n-1][i];
        int count=0;
        for(int j=i;j<5;j++){
            count+=helper(n-1,j);
        }
        dp[n-1][i]=count;
        return dp[n-1][i];
    }
    */
    //O(1) 0ms combination math
    // https://leetcode.com/problems/count-sorted-vowel-strings/discuss/1021493/One-line-solution-or-Math-or-No-DP-no-Big-Integers-or-O(1)-time-space
    //https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918392/Very-Easy-Solution-or-No-DP-or-No-Math-Formula-or-Solving-for-n-3-reveals-the-pattern
      public int countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
}
