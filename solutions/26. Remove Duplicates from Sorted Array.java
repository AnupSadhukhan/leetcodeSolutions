class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int k=0;
        for(int i=1;i<nums.length;i++){
            if(nums[k]!=nums[i]){
                k++;
                int tmp = nums[k];
                nums[k]=nums[i];
                nums[i]=tmp;
            }
        }
        return k+1;
    }
}
