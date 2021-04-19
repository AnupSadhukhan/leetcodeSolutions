class Solution {
    // we will use memorization technique with DFS. From each position(x,y) we will move
    //count its return value and we will also move to right side of x,y and we will add up
    // the return value to total count from position x,y. We will store this value in dp 
    // so that next time if same position comes,we will simply return the value instead
    // of calculating same value again again    
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return count(0,0,m-1,n-1);
    }
    public int count(int x,int y,int m,int n){
        if(dp[x][y]!=-1) return dp[x][y];
        if(x==m && y==n) return 1;
        int count=0;
        if(x+1<=m) count+=count(x+1,y,m,n);
        if(y+1<=n) count+=count(x,y+1,m,n);
        dp[x][y]=count;
        return dp[x][y];
    }
}
