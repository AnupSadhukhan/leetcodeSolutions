class Solution {
    /*// O(2^n)
    public boolean canPartition(int[] nums) {
        
        return equalSum(nums,0,0,0);
    }
    public boolean equalSum(int[] nums,int a,int b,int idx){
        if(idx==nums.length && a==b) return true;
        if(idx==nums.length && a!=b) return false;
        return equalSum(nums,a+nums[idx],b,idx+1) || equalSum(nums,a,b+nums[idx],idx+1);
    }*/
    public boolean canPartition(int[] nums) {
        if(nums.length<2) return false;
       int sum=0;
       for(int n : nums){
           sum+=n;
       }
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            boolean[] dp1=new boolean[target+1];
           
            for(int j=0;j<target+1;j++){
                if(dp[j] || (j-nums[i]>=0 && dp[j-nums[i]])){
                    dp1[j]=(dp[j]|| true);
                }
            }
            dp=dp1;
        }
        return dp[target];
       
    }
}
