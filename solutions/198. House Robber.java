class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int p0=0;
        int p1=nums[0];
        int max=0;
        for(int i=1;i<nums.length;i++){
            max=Math.max(nums[i]+p0,p1);
            p0=p1;
            p1=max;
        }
        return max;
    }
}
