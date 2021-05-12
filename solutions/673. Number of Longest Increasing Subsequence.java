class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=0;
        int[] count=new int[nums.length];
        Arrays.fill(count,1);
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]==1+dp[j])count[i]+=count[j];
                    if(dp[i]<1+dp[j]){
                        dp[i]=1+dp[j];
                         count[i]=count[j];
                    }
                    
                    
                }
              
            }
           if(max==dp[i]) res+=count[i];
            if(max<dp[i]){
                
                max=dp[i];
                res=count[i];
            }
           
        }
     
        return res;
        
    }
   
}
