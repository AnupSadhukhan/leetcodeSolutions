class Solution {
    public int minOperations(int n) {
        if(n==1) return 0;
        int avg=(((1+(2*(n-1)+1))*n)/2)/n;
        int half=n/2;
        int halfSum=((1+(2*(half-1)+1))*half)/2;
        return (half*avg)-halfSum;
    }
}
