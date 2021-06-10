class Solution {
    // follow kadane's algo
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int curMax=0;
        for(int i=0;i<nums.length;i++){
            curMax+=nums[i];
            max=Math.max(curMax,max);
            if(curMax<0){
                curMax=0;
            }
        }
        return max;
    }
}
