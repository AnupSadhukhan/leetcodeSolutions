class Solution {
    public int longestOnes(int[] A, int K) {
        int count1=0;
        int left=0;
        int flip=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]==1){
                count1++;
            }
            flip=i-left+1-count1;
            while(flip>K){
                if(A[left++]==1){
                    count1--;
                }
                flip=i-left+1-count1;
            }
            max=(i-left+1)>max?(i-left+1):max;
        }
        return max==Integer.MIN_VALUE?0:max;
        
    }
}
