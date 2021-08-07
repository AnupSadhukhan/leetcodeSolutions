class Solution {
    // worst case - O(n) because if all are same elems, 
    // best case - O(logn) all are distinct
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            while(left<right && nums[left]==nums[left+1]) left++;
            while(left<right && nums[right] == nums[right-1]) right--;
            int mid = (right-left)/2 + left;
            if(nums[mid]==target) return true;
            if(target<nums[mid]){
                if(target<=nums[right] && nums[mid]>nums[right]){
                    left = mid+1;
                }
                else right = mid-1;
            }
            else{
                if(target>nums[right] && nums[mid]<nums[right]) right = mid-1;
                else left = mid+1;
            }
        }
        return false;
    }
}
