class Solution {
    /* we will find median bcz otherwise if we use avg or any other technique that
    will give us wrong ans, imagine one elemnet is so small or so large 
    than other elemnets, in that case if we use avg, it will not give minimum value
    so we will use median to get min move*/
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int median=0;
        if(n%2==0){
            median=(nums[n/2]+nums[(n/2)-1])/2;
        }
        else{
            median=nums[n/2];
        }
        int move=0;
        for(int x : nums){
            move+=Math.abs(x-median);
        }
        return move;
    }
}
