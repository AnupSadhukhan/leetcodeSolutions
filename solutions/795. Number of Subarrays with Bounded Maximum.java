class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        /*int leftPoint=-1;
        int i=0;
        int maxElem=-1;
        int count=0;
        int rightHi=-1;
        while(i<nums.length){
            if(maxElem<nums[i]){
                maxElem=nums[i];
            }
            if( maxElem>right){
                maxElem=-1;
                leftPoint=i;
                rightHi=i;
                i++;
                continue;
            }
            else if(nums[i]>=left && nums[i]<=right){
                rightHi=i;
                //count++;
            }
            count+=(rightHi-leftPoint);
           
            i++;
        }
        return count;*/
        int res=0;
        int n = nums.length;        
        int ind=-1,valid=-1;        
        for(int i=0;i<n;i++){            
                                    
            if(nums[i]>right){
                ind=i;
                valid=i;
            }
            else if(nums[i]>=left && nums[i]<=right)
                valid = i;
                        
            res+= valid-ind;            
        }
        return res;
    }
}
