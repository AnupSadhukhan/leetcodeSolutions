class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
       Set<String> set=new HashSet<>();
        int n=nums.length;
       List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            //System.out.println("loop -1");
            for(int j=i+1;j<n-2;j++){
                //System.out.println("loop -2");
                int x = target - nums[i] - nums[j];
                int left = j+1;
                int right = n-1;
                while(left < right){
                    //System.out.println("loop -3");
                    int sum = nums[left] + nums[right];
                    if(sum<x) {
                        left++;
                        
                    }
                    else if(sum>x){
                       
                        right--;
                    }
                    else{
                        String s = nums[i]+"-"+nums[j]+"-"+nums[left]+"-"+nums[right];
                        if(!set.contains(s))
                            result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        set.add(s);
                        left++;
                        
                    }
                   //System.out.println("loop -3 end");
                }
            }
        }
        return result;
    }
}
