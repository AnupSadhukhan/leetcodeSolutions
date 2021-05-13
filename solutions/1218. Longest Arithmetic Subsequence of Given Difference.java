class Solution {
    // Its like an AP with constant difference, so we will use hashmap
    // which will store arr[i] as a key and map.get(arr[i]-difference)+1
    // as length, using this technique , we will store and also keep a track
    // of highest length, at the end return longest value.
    public int longestSubsequence(int[] arr, int difference) {
       int longest=0;
       Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            Integer x=map.getOrDefault(arr[i]-difference,0)+1;
            map.put(arr[i],x);
            longest=Math.max(longest,x);
        }
        return longest;
    }
}
