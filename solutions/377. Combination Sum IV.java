class Solution {
    //https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
    // This problem is similar to coin change II. but in that problem order didn't matter
    // where as in this problem, diff order with same combination is counter as different. so, we
    // have tweak the solution a little bit. to count diff order. so, we will make an dp with size of target+1, for
    // sum 0, combination is always 1, then for 2..target we will iterate over the all elements. if for a elements
    // there is some combination that means for that sum we can make that many possible of combination. so we will
    // count that valus with for current sum..
    // e.g. arr = [1,2,3]; target=4
    // dp=[1,0,0,0,0];
    //sum = 1 elm = 1..2..3, dp=[1,1,0,0,0]
    // sum =2 elm = 1..2..3, dp=[1,1,2,0,0] {(1,1),(2)} , 
    // sum=3 elm = 1  dp=[1,1,2,2,0], elm =2, dp=[1,1,2,3,0], elm=3, dp=[1,1,2,4,0]
    // sum=4 elm = 1  dp=[1,1,2,4,4], elm =2, dp=[1,1,2,4,6], elm=3, dp=[1,1,2,4,7] 
    //rule: dp[sum]=dp[sum-elm1]+dp[sum-elm2]+dp[sum-elm3]... for all elements if(sum-elm>=0)
    
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        /*int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>=0){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];*/
        dp=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        return  helper(nums,target);
    }
    public int helper(int[] nums,int target){
    
        if(target<0) return 0;
        if(dp[target]>-1) return dp[target];
        int res=0;
        for(int i :  nums){
            res+=helper(nums,target-i);
        }
        dp[target]=res;
       
        return dp[target];
    }
}
