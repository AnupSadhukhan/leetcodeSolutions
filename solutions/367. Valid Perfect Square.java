class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        if(Integer.MAX_VALUE==num) return false;
        int left = 1, right =46341;
        long mul =1L;
        long target = num;
        while(left<=right){
            int mid = (right - left)/2 + left;
            mul = mid * mid;
            //System.out.println(mid+" "+left+" "+right+" "+mul);
            if(mul==target) return true;
            if(mul>target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}
