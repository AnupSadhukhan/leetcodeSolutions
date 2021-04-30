class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx=Arrays.binarySearch(nums,target);
        if(idx<0){
            return new int[]{-1,-1};
        }
        else{
            int left=idx;
            while(left>=0 && nums[left]==nums[idx]) left--;
            int right=idx;
            while(right<nums.length && nums[right]==nums[idx])right++;
            return new int[]{left+1,right-1};
        }
    }
}
