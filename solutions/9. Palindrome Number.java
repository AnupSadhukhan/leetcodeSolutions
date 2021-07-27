class Solution {
    public boolean isPalindrome(int x) {
        /*char[] chs = (x+"").toCharArray();
        int left =0;
        int right = chs.length-1;
        while(left<right){
            if(chs[left]!=chs[right]) return false;
            left++;
            right--;
        }
        return true;*/
        if(x<0 || (x!=0 && x%10==0)) return false;
        
        int reverseX = 0;
        int tmp = x;
        while(tmp>0){
            int rem = tmp%10;
            reverseX = (reverseX*10)+rem;
            tmp = tmp/10;
        }
        return x == reverseX;
    }
}
