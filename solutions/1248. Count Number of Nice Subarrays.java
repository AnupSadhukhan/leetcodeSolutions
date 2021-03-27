class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0,ans=0;
        int low=0,high=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                count++;
            }
            while(low<=i && count>k){
                if(nums[low++]%2!=0){
                    count--;
                }
            }
            high=low;
            while(high<=i && count==k && nums[high]%2==0){
                
                high++;
            }
            
            if(count==k){
                ans+=high-low+1;
            }
            
        }
        return ans;
    }
}
