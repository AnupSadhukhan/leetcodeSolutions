class Solution {
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
