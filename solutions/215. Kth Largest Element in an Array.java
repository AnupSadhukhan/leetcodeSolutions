class Solution {
    /* quick select pivot last elm */
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        if(k<0 && k>=n) return Integer.MAX_VALUE;
        
        return quickselect(nums,0,n-1,k,n);
    }
    private int quickselect(int[] nums, int left,int right, int k,int n){
        
        int pi = partition(nums,left,right);
        if(n-pi==k) return nums[pi];
        if(n-pi>k){
            return quickselect(nums,pi+1,right,k,n);
        }
        return quickselect(nums,left,pi-1,k,n);
    }
    private int partition(int[] nums,int left,int right){
        int pivot = nums[right];
        int piIndex = left;
        for(int i=left;i<right;i++){
            if(nums[i]<pivot){
                int tmp = nums[piIndex];
                nums[piIndex] = nums[i];
                nums[i] = tmp;
                piIndex++;
            }
        }
        
        int tmp = nums[piIndex];
        nums[piIndex] = nums[right];
        nums[right] = tmp;
        
        return piIndex;
    }
}
