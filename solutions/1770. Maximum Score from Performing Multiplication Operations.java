class Solution {
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
       dp=new Integer[multipliers.length][multipliers.length];
        return maxScore(0,0,nums,multipliers);
        
    }
    public int maxScore(int i,int left,int[] nums,int[] mul){
      
        if(i>=mul.length) return 0;
        if(dp[i][left]!=null) return dp[i][left];
        int leftS=(nums[left]*mul[i])+maxScore(i+1,left+1,nums,mul);
        int rightS=(nums[nums.length-1-(i-left)]*mul[i])+maxScore(i+1,left,nums,mul);
        
        return dp[i][left]=Math.max(leftS,rightS);
    }
}
