class Solution {
    List<List<Integer>> result;
    //Set<String> set;
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result=new ArrayList<>();
        //set=new HashSet<>();
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
