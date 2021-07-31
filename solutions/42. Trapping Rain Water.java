class Solution {
    /* O(n) - 3ms
    public int trap(int[] height) {
        if(height.length<3) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;
        for(int i = 1; i < height.length; i++){
            while(!stack.empty() && height[stack.peek()]<height[i]){
                
                int cur = height[stack.pop()];
                if(stack.empty()) break;
                int prev = height[stack.peek()];
                int minHeight = Math.min(height[i],prev);
                int dist = i - stack.peek() - 1;
                result+=(dist*(minHeight-cur));
            }
            stack.push(i);
        }
        return result;
    }
    */
    // two pointer technique - 0ms
     public int trap(int[] height) {
         if(height.length<3) return 0;
         int left = 0;
         int right = height.length-1;
         int leftMax = 0;
         int rightMax = 0;
         int ans = 0;
         while(left<right){
             if(height[left]<height[right]){
                 if(height[left]>=leftMax) leftMax = height[left];
                 else ans = ans + leftMax - height[left];
                 left++;
             }
             else{
                 if(height[right]>=rightMax) rightMax = height[right];
                 else ans = ans + rightMax - height[right];
                 right--;
             }
         }
         return ans;
     }
}
