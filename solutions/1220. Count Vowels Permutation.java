class Solution {
   /* //DFS + memorization = 25 ms
    int[][] dirs={{1},{0,2},{0,1,3,4},{2,4},{0}};
    int[][] dp;
    public int countVowelPermutation(int n) {
       int count=0;
        dp=new int[n][5];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<5;i++){
            count=(count+count(n-1,i))%1000000007;
        }
        return count;
    }
    public int count(int n,int i){
        if(n==0) return 1;
        if(dp[n-1][i]!=-1) return dp[n-1][i];
        int count=0;
        for(int x:dirs[i]){
            count=(count+count(n-1,x))%1000000007;
        }
        dp[n-1][i]=count;
        return dp[n-1][i];
    }*/
    
     public int countVowelPermutation(int n) {
         long aCount=1,eCount=1,iCount=1,oCount=1,uCount=1;
         //long count=0;
         int mod=1000000007;
         long aCountNew=0,uCountNew=0,eCountNew=0,iCountNew=0,oCountNew=0;
         for(int i=1;i<n;i++){
             aCountNew=(eCount + iCount + uCount) %mod;
             eCountNew = (aCount + iCount) % mod;
             iCountNew = (eCount + oCount) % mod;
             oCountNew = iCount %mod;
             uCountNew = (iCount + oCount) % mod;
             
             aCount = aCountNew;
             eCount = eCountNew;
             iCount = iCountNew;
             oCount = oCountNew;
             uCount = uCountNew;
             
             
         }
         long result = (aCount + eCount + iCount + oCount + uCount)%mod;
         return (int) result;
         
         
     }
    
}
​
