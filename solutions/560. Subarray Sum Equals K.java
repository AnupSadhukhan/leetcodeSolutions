class Solution {
    // create a hashmap which will store the sum and their frequency
    // use prefix sum, check if sum-k is present in hashmap or not,
    // there is basically two case
    // case I: target sum is the sum from index 0 to i
    // case II: tager sum is the sum from index i to j, means k=(sum)-(sum-k)
    // so, if there exist any sum (sum-k) from 0 to i-1, then sum from i to j is k
    // sum is the sum from 0 to j, sum-k is the sum from 0 to i-1, so i to j is k
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,count=0;
        // if sum from 0 to i is equal to k, we have an subarray, we need to increase count;
        map.put(0,1);
        for(int num : nums){
            sum+=num;
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
