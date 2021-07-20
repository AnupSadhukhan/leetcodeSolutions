class Solution {
    private int[] arr;
    private int[] original;
    public Solution(int[] nums) {
        this.arr = nums;
        this.original = Arrays.copyOf(nums,nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.arr= Arrays.copyOf(original,original.length);
        
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int randomIndexRange = arr.length-1;
        Random random = new Random();
        for(int i = randomIndexRange;i>=0;i--){
            int index = random.nextInt(i+1);
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
        return arr;
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
