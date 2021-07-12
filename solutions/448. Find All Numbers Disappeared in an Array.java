class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] appered=new boolean[nums.length+1];
        for(int i=0;i<nums.length;i++){
            
            appered[nums[i]]=true;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<nums.length+1;i++){
            if(!appered[i]) result.add(i);
        }
        return result;
    }
}
