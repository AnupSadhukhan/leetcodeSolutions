class Solution {
    // we can use sorting and set to check duplicate, but if we 
    // follow the constraint then we have to solve it using 
    // floyd's tortoise and hare (cycle detection) algo
    // check approch 3 in the solution for better understanding
    public int findDuplicate(int[] nums) {
        // 30ms
      /* Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) return nums[i];
        }
        return 0;*/
        //5ms
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        while(slow!=fast);
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
