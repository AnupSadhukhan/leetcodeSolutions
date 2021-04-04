class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[2][matrix.length];
        Integer res=(int) 1e7;
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
          
            
        }
      
        int min=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                min=dp[(i-1)%2][j];
              
                if(j-1>=0)min=Math.min(dp[(i-1)%2][j-1],min);
             
                if(j+1<n)min=Math.min(min,dp[(i-1)%2][j+1]);
             
                dp[i%2][j]=min+matrix[i][j];
          
            }
       
        }
        for(int i=0;i<n;i++){
            if(dp[(n-1)%2][i]<res) res=dp[(n-1)%2][i];
        }
        return res;
    }
}
