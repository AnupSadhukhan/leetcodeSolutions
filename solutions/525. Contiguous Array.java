class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==1?1:-1);
            if(sum==0){
                max=max<i+1?i+1:max;
            }
            else if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return max;
    }
}
