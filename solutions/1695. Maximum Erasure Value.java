class Solution {
    /* This is window sliding problem, we will keep track of elements,
      and sum of those elements, if a element is already seen we will shrink 
      the window and reduce the sum, at the end will retun max possible sum
      */
    public int maximumUniqueSubarray(int[] nums) {
        if(nums.length==1) return nums[0];
        boolean[] vis=new boolean[10001];
        int sum=0;
        int max=0;
        int left=0;
        for(int i=0;i<nums.length;i++){
        
                while(left<=i && vis[nums[i]]){
                    vis[nums[left]]=false;
                    sum-=nums[left];
                    left++;
                    
                }
           
               sum+=nums[i];
            vis[nums[i]]=true;
            max=Math.max(max,sum);
            
        }
        return max;
    }
}
