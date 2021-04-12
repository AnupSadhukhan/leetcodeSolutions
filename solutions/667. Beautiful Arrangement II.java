class Solution {
    public int[] constructArray(int n, int k) {
        int[] res=new int[n];
        int left=1,right=k+1;
        int i=0;
        while(left<=right){
            if(i%2==0){
                res[i++]=left++;
                continue;
            }
            res[i++]=right--;
        }
        while(i<n){
            res[i]=i+1;
            i++;
        }
        return res;
    }
}
