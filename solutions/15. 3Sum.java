class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<3) return result;
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        Set<String> set=new HashSet<>();
        while(left<right && right-left>=2){
            
            if(left==0 || nums[left]!=nums[left-1]){
                 int i=left;
                int j=left+1;
                int k=right;
​
​
                while(j<k){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(sum==0){
                       
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        j++;
                        k--;
                        while(j<k && nums[j]==nums[j-1]) j++;
                        while(j<k && nums[k]==nums[k+1]) k--;
                        
                    }
                    else if(sum<0){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
                
            }
            left++;
           
           
        }
        return result;
    }
}
