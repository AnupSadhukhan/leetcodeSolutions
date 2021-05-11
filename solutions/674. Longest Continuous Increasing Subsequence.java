class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // O(n^2)
       /* int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int len=1;
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[j-1]) len++;
                else break;
            }
            max=Math.max(max,len);
        }
        return max;*/
        
      // O(n)
       int max=0;
       int start=0;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]<=nums[i-1]) start=i;
            max=Math.max(max,i-start+1);
        }
        return max;
        
    }
   
}
