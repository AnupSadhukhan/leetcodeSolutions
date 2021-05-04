class Solution {
    // 1 ms
    // I'm checking dropping point and measuring difference of dropping point+2 and dropping point
    // and dropping point+1 and dropping point-1, if difference is greater than 0 that means I can change
    // that element and make it same value or value between these two value and my array will be 
    // non decresing, but if we get droppin point again, then array can not be non-drecsing, so return false;
    // else check condition and difference and if all okay return true;
    public boolean checkPossibility(int[] nums) {
        int first=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                if(first==-1){
                    first=i-1;
                   
                }
                
                else return false;
            }
            else{
                max=nums[i];
            }
        }
        if(first!=-1 && first!=0 && first!=nums.length-2){
            if(first+2<nums.length && nums[first+2]-nums[first]>=0) return true;
            else if(first-1>=0 && first+1<nums.length && nums[first+1]-nums[first-1]>=0) return true;
            return false;
        }
        return true;
    }
    //0ms
     /* public boolean checkPossibility(int[] nums) {
        if(nums==null || nums.length<=2) return true;
        
        int count = 0;
        int prev = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]<prev){
                if(++count>1) return false;
                if(i>=2 && nums[i]<nums[i-2]) continue;
            }
            prev = nums[i];
        }
        return true;
    }*/
}
