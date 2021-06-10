class Solution {
    // mono queue
    public int maxResult(int nums[],int k){
        int cur=0;
        Deque<Integer> queue=new LinkedList<>();
        for(int i=nums.length-1;i>=0 ;i--){
            cur=nums[i]+(queue.isEmpty()?0:nums[queue.peekFirst()]);
            
            while(!queue.isEmpty() && cur>nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(queue.peekFirst()>=i+k){
                queue.pollFirst();
            }
            nums[i]=cur;
        }
        return cur;
       
    }
    
     
}
