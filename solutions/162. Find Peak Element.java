class Solution {
    public int findPeakElement(int[] nums) {
        //O(n)
       /* int max=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]) {
                max = nums[i]; 
                index = i;
            }
        }
        return index;*/
        // O(logn)
        int right = nums.length-1;
        int left = 0;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[mid+1]) right=mid;
            else left=mid+1;
        }
        return left;
    }
}
