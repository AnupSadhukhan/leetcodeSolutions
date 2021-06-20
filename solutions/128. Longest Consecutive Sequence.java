class Solution {
    /* initialize window size as 1 every time then check 
    and run while curNum-1 is present in the left side, incrase window size,
    run while curNum+1 is presnt in the right size, increase window size,
    update result as max of window size;
    return max result;
    */
    //O(n) 5ms
    public int longestConsecutive(int[] nums) {
        Set<Integer> input = new HashSet<>();
        Set<Integer> visited = new HashSet<>();        
        int curr, window, result = 0;
        
        for (int num: nums) input.add(num);
        
        for (int num: input) {
            if (visited.contains(num)) continue;
            
            window = 1;
            
            // go left;
            curr = num-1;
            while (input.contains(curr)) {
                window++;
                visited.add(curr);
                curr--;
            }
                
            // go right
            curr = num+1;
            while (input.contains(curr)) {
                window++;
                visited.add(curr);
                curr++;                
            }
            
            result = Math.max(window, result);
        }
        
        return result;
    }
   /* 35ms O(n)
   public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        Map<Integer,int[]> map=new HashMap<>();
        int max=0;
        for(int num : nums){
            if(map.get(num)==null){
                int[] up=map.get(num+1);
                int[] down=map.get(num-1);
                if(up!=null && down!=null){
                    int[] dist=new int[]{1};
                    dist[0]+=up[0];
                    dist[0]+=down[0];
                    
                    
                    map.put(num+up[0],dist);
                    map.put(num-down[0],dist);
                    map.put(num,dist);
                    max=Math.max(max,dist[0]);
                }
                else if(up==null && down!=null){
                    down[0]++;
