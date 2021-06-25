class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int elm : nums){
            Integer freq=map.getOrDefault(elm,0)+1;
            if(freq>nums.length/2) return elm;
            map.put(elm,freq);
        }
        return -1;
    }
}
