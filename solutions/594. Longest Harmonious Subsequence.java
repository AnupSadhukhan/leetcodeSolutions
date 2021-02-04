class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            int key=m.getKey();
            int c=map.getOrDefault(key-1,0);
            if(c!=0){
                max=max<c+m.getValue()?c+m.getValue() : max;
            }
        }
        return max;
    }
}
