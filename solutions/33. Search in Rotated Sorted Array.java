class Solution {
    public int search(int[] nums, int target) {
       
        int left=0;
        int right=nums.length-1;
        if(nums[left]==target) return left;
        if(nums[right]==target) return right;
        
        
        while(left<=right){
            int mid=(left+right)/2;
           
            if(nums[mid]==target) return mid;
            else if((target>nums[mid] && target>nums[right] && nums[mid]<nums[right]) ) {
                
                right=mid-1;
            }
            else if(target<nums[mid] && target<=nums[right] && nums[mid]>nums[right]){
               
                left=mid+1;
            }
            else if(target<nums[mid]){
               
                right=mid-1;
            }
            else {
             
                left=mid+1;
            }
            
            
          
        }
        return -1;
    }
}