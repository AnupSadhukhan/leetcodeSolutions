class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //int[] min=new int[triangle.size()];
        int min=triangle.get(0).get(0);
        
        int n=triangle.get(triangle.size()-1).size();
        if(n==1) return min;
        int[][] dp=new int[2][n];
        
        for(int i=n-1;i>=0;i--){
           
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                 if(i==n-1){
                     dp[i%2][j]=triangle.get(i).get(j);
                }
                else{
                    int x=triangle.get(i).get(j);
                    dp[i%2][j]=Math.min(x+dp[(i+1)%2][j],x+dp[(i+1)%2][j+1]);
                }
            }
        }
       
        return dp[0][0];
        
        
    }
   
    
}
