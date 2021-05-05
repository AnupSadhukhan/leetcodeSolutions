class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums);
    }
    public int helper(int i, int[] nums){
        if(i>=nums.length) return nums.length;
        if(dp[i] != -1) return dp[i];
        if(i==nums.length-1) return 0;
        int min = nums.length;
        for(int j=i+1; j<=i+nums[i];j++){
            min=Math.min(min,1+helper(j,nums));
            
        }
        dp[i] = min;
                         return dp[i];
     }
}
