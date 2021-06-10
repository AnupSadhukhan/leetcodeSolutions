class Solution {
    // mono decreasing deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            
            while(!queue.isEmpty() && queue.peekFirst()<i-(k-1)){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(i>=k-1){
                ans[i-(k-1)]=nums[queue.peekFirst()];
            }
        }
        return ans;
        
    }
}
