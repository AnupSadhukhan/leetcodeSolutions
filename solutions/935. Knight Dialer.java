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
        if (N == 1) return 1;
        long num = 0;
        if ( cache[next][N] != 0) {
            return cache[next][N];
        }
        
        for (int adj : adjs[next]) {
            num += knightDialerCached(adj, N-1) % M ;
        }
        num %= M;
        cache[next][N] = num;
        return num;
    }
​
        
}
