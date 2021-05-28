class Solution {
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
