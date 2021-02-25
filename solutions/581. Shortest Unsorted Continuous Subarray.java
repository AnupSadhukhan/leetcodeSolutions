class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int curr_min=Integer.MAX_VALUE;
        int start=-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<curr_min) curr_min=nums[i];
            if(nums[i]>curr_min) start=i;
        }
        int curr_max=Integer.MIN_VALUE;
        int end=-1;
        for(int i=0;i<nums.length;i++){
            if(curr_max<nums[i]) curr_max=nums[i];
            if(curr_max>nums[i])end=i;
        }
        if(start==-1) return 0;
        return end-start+1;
    }
}
