class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        permuteArray(nums,0);
        return result;
    }
    private void permuteArray(int[] nums,int start){
     
        if(start==nums.length){
          
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        } 
​
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            permuteArray(nums,start+1);
            swap(nums,i,start);
            
        }
    }
    private void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
   
}
