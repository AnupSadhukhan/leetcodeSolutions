class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int closestSum = 0;
        for(int i = 0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            //int x = target - nums[i];
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                int dist = Math.abs(target-sum);
                if(closest>dist){
                    closest = dist;
                    closestSum = sum;
                }
                
                if(sum==target) return target;
                else if(sum<target){
                    left++;
                }
                else if(sum>target) right--;
                
                
            }
        }
        return closestSum;
    }
}
