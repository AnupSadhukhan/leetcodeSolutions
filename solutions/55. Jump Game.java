class Solution {
    // dp - 1009 ms O(n^2)
   /* int[] dp;
    public boolean canJump(int[] nums) {
        dp=new int[nums.length];
        return dfs(nums,0);
    }
    public boolean dfs(int[] nums,int i){
        
        if(i>=nums.length) return false;
        if(i==nums.length-1 || nums[i]+i>=nums.length-1) return true;
        if(dp[i]==-1) return false;
        int jump=nums[i];
        while(jump>0){
            if(dfs(nums,i+jump)) return true;
            jump--;
        }
        dp[i]=-1;
        return false;
    }*/
    //greedy - 0ms - O(n)
    public boolean canJump(int[] nums) {
        int lastPos=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=lastPos){
                lastPos=i;
            }
           
        }
        return lastPos==0;
    }
}
