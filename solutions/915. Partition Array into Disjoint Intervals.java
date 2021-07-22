class Solution {
    public int partitionDisjoint(int[] nums) {
       int dist = 1;
        int max = nums[0];
        int pMax = max;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<max){
                max=pMax;
                dist = i+1;
            }
            else pMax = Math.max(pMax,nums[i]);
        }
        return dist;
    }
}
