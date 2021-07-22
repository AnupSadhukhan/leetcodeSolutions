class Solution {
  /*  List<List<Integer>> result;
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
   */
    List<List<Integer>> result;
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        result=new ArrayList<>();
        vis=new boolean[nums.length];
        permuteArray(nums,new ArrayList<>());
        
        return result;
    }
    private void permuteArray(int[] nums,List<Integer> list){
     
        if(list.size()==nums.length){
          
            result.add(new ArrayList<>(list));
               
            return;
        } 
​
        for(int i=0;i<nums.length;i++){
            if(vis[i]){
             
                 continue;
            }
            if(i>0 && !vis[i-1] && nums[i]==nums[i-1]){
                
                continue;
            } 
            vis[i] = true;
            list.add(nums[i]);
            permuteArray(nums,list);
            list.remove(list.size()-1);
            vis[i] = false;
            
        }
    }
}
