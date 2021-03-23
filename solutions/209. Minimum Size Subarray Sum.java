class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      //  Arrays.sort(nums);
        int len=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        int left=0;
        for(int i=0;i<nums.length;i++){
            
            sum+=nums[i];
             //System.out.println("1 "+sum+" added "+nums[i]);
            if(sum>target){
                while(sum>target && left<=i){
                    sum-=nums[left];
                    //System.out.println("del "+nums[left]+" now sum "+sum);
                    len=i-left+1;
                    min=min>len?len:min;
                    left++;
                    
                }
                
               // System.out.println("left "+left+" sum "+sum);
            }
           // System.out.println("2 "+sum);
             if(sum==target){
                len=i-left+1;
                 
                 min=min>len?len:min;
                
            }
           
        }
       
        return min==Integer.MAX_VALUE?0:min;
    }
}
