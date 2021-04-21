class Solution {
    // use DFS with Memorization technique
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,triangle);
    }
    public int helper(int index,int level,List<List<Integer>> triangle){
        if(level>=triangle.size()) return 0;
        if(dp[level][index]!=-1) return dp[level][index];
        dp[level][index]=triangle.get(level).get(index)+Math.min(helper(index,level+1,triangle),helper(index+1,level+1,triangle));
     return dp[level][index];
    }
}
