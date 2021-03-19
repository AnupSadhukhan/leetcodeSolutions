class Solution {
    public int wiggleMaxLength(int[] nums) {
         //System.out.println("new");
        if(nums.length<=2) return 1;
        
        int prev=nums[1]-nums[0];
        int len=2;
        if(nums[1]-nums[0]==0)len = 1;
       
        //System.out.println(nums[1]-nums[0]);
        for(int i=2;i<nums.length;i++){
            int diff=nums[i]-nums[i-1];
           
            if((prev>=0 && diff<0) || (prev<=0 && diff>0)){
                len++;
                prev=diff;
            }
            
        }
        return len;
    }
}
