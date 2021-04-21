class Solution {
    /* DFS 3D sol 232ms */
    /*boolean[][] vis;
    int[][][] dp;
    int[][] dir=new int[][]{{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
    public int knightDialer(int n) {
        vis=new boolean[4][3];
        vis[3][0]=true;
        vis[3][2]=true;
        dp=new int[n][4][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int count=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(!vis[i][j]){
                    count=(count+helper(i,j,n-1))%1000000007;
                }
            }
        }
        return count;
    }
    public int helper(int i,int j,int n){
        if(n==0) return 1;
        if(dp[n-1][i][j]!=-1) return dp[n-1][i][j];
        int count=0;
           
        for(int[] d : dir){
            int i1=i+d[0];
            int j1=j+d[1];
            if(i1>=0 && i1<4 && j1>=0 && j1<3){
                 if(!vis[i1][j1])
                count=(count+helper(i1,j1,n-1))%1000000007;
            }
        }
        dp[n-1][i][j]=count;
        return dp[n-1][i][j];
    }
    */
    static int[][] adjs = { {4,6}, {6,8}, {7,9}, {4,8}, {0,3,9}, {}, {0,1,7}, {2,6}, {1,3}, {2,4} }; 
​
​
    //for each (digit, #hops) -> how many numbers
    static long[][] cache = new long[10][5001];
    
    static long M = (long)Math.pow(10,9) + 7;
​
    //given N hops, what's the maximum no of numbers
    //that can be dialed irregardless of starting pos
    public int knightDialer(int N) {
        long num = 0;
        for (int i=0; i<10; i++) {
            num += (knightDialerCached(i,N)) % M;
        }
        return (int)(num % M);
    }
    
    long knightDialerCached(int next, int N) {
        if (N == 0) return 0;
