class Solution {
    
    int[][] dp;
    public int mctFromLeafValues(int[] arr) {
        dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,arr.length-1,arr);
    }
    public int helper(int i,int j,int[] arr){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            min=Math.min(min,getMax(i,k,arr)*getMax(k+1,j,arr)+helper(i,k,arr)+helper(k+1,j,arr));
        }
        dp[i][j]=min;
        return dp[i][j];
    }
    public int getMax(int i, int j,int[] arr){
        if(i>j) return 1;
        int max=arr[i];
        for(int k=i+1;k<=j;k++){
            max=Math.max(max,arr[k]);
        }
        return max;
    }
}
