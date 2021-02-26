class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffle=new int[2*n];
        for(int i=0,j=0;i<2*n;i++,j++){
            shuffle[i]=nums[j];
            shuffle[++i]=nums[j+n];
        }
        return shuffle;
    }
}
