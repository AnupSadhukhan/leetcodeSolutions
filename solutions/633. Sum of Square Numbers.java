class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while(left<=right){
            int mul = left*left+right*right;
            if(mul==c) return true;
            if(mul>c) right--;
            else left++;
        }
        return false;
    }
}
