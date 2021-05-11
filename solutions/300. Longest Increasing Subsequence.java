class Solution {
 
    public int lengthOfLIS(int[] nums) {
      // O(n^2)
       /* int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
         int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],1+dp[j]);
            }
            
           max=Math.max(max,dp[i]);
        }
        return max;*/
        //O(nlogn)
        int[] dp=new int[nums.length];
        int len=0;
        for(int i=0;i<nums.length;i++){
            int idx=Arrays.binarySearch(dp,0,len,nums[i]);
            if(idx<0){
                idx=-(idx+1);
            }
            dp[idx]=nums[i];
            if(idx==len) len++;
        }
        return len;
    }
   
}
