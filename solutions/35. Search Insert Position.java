class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums,0,nums.length-1,target);
        return index;
    }
    private int binarySearch(int[] nums, int left,int right,int target){
        if(left>right) return left;
        int mid = (left + right)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]> target) return binarySearch(nums,left,mid-1,target);
        return binarySearch(nums,mid+1,right,target);
    }
}
