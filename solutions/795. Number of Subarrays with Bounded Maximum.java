class Solution {
    /* use two pointer to point last valid number position which is lying inside the bound and 
       first valid number position, 
       if any number is not less than boundary value, that number still can be a part of 
       a subarray as long as max element number is between the boundary but the number it self can not be
       a subarray,
       if any number is greater than higest boundary that means this number neither can be a
       subarray nor can be a part of another subarray, so reset two pointer to this position,
       when there is valid number, change one pointer(pointer1) and after each iteration count subarray as (pointer2-pointer1)
       */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        /*int leftPoint=-1;
        int i=0;
        int maxElem=-1;
        int count=0;
        int rightHi=-1;
        while(i<nums.length){
            if(maxElem<nums[i]){
                maxElem=nums[i];
            }
            if( maxElem>right){
                maxElem=-1;
                leftPoint=i;
                rightHi=i;
                i++;
                continue;
            }
            else if(nums[i]>=left && nums[i]<=right){
                rightHi=i;
                //count++;
            }
            count+=(rightHi-leftPoint);
           
            i++;
        }
        return count;*/
        int res=0;
        int n = nums.length;        
        int ind=-1,valid=-1;        
        for(int i=0;i<n;i++){            
                                    
            if(nums[i]>right){
                ind=i;
                valid=i;
            }
            else if(nums[i]>=left && nums[i]<=right)
                valid = i;
                        
            res+= valid-ind;            
        }
        return res;
    }
}
