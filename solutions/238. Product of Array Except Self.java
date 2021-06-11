class Solution {
    /* if there are more than one zero then all elements will become zero,
     because at to the left or right there will be atleast one zero hence
      product will become zero, so in this case we will simply return newly created 
      result array without any modification else if there is only one zero,
      then all elements will become zero except product at that index will be
      product of left elems and product of right elems.
      if there there is no zero elements then we will calculate products of all elems
      and result array's elems will be (product of all elems/element) and return this 
      result
      */
    public int[] productExceptSelf(int[] nums) {
              
        int product=1;
        int indexOfZero=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                
                if(indexOfZero!=-1){
                    Arrays.fill(nums,0);
                    return nums;
                }
                indexOfZero=i;
                
            }
            else product*=nums[i];
        }
        if(indexOfZero!=-1){
            Arrays.fill(nums,0);
            nums[indexOfZero]=product;
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=product/nums[i];
        }
        return nums;
    }
}
