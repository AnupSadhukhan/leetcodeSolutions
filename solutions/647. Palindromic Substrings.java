        // Base case: double letter substrings
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i + 1] ? 1 : 0);
        }
​
        // All other cases: substrings of length 3 to n
        for (int len = 3; len <= n; ++len)
            for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                ans += (dp[i][j] ? 1 : 0);
            }
​
        return ans;
       */
        /*int n=s.length();
        int[][] dp=new int[n][n];
        boolean[][] vis=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
            vis[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=3;
                vis[i][i+1]=true;
            }
            else{
                dp[i][i+1]=2;
                vis[i][i+1]=false;
            } 
        }
        for(int i=2;i<n;i++){
            for(int j=0,k=i+j;j+i<n;j++,k++){
                if(vis[j+1][k-1] && s.charAt(j)==s.charAt(k)){
                    dp[j][k]=1+dp[j+1][k]+dp[j][k-1]-dp[j+1][k-1];
                    vis[j][k]=true;
                }
                else{
                     dp[j][k]=dp[j+1][k]+dp[j][k-1]-dp[j+1][k-1];
                    vis[j][k]=false;
                }
            }
        }
       
         return dp[0][n-1];*/
        
        //eturn recursion(dp,s,0,s.length()-1);
        
    }
   /* public int recursion(int[][] dp,String s,int left,int right){
        if(left>right) return 0;
        if(dp[left][right]!=0) return dp[left][right];
        if(right-left+1<=1) return left-right+1;
