class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        
        for(int num : nums2){
            while(!stack.empty() && stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        int[] ans=new int[nums1.length];
        int i=0;
        for(int num : nums1){
            ans[i]=map.getOrDefault(num,-1);
            i++;
        }
        return ans;
    }
}
