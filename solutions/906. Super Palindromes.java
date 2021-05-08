class Solution {
    public int superpalindromesInRange(String left, String right) {
        List<String> palindrome=new ArrayList<>();
        long leftl=Long.parseLong(left);
        long rightl=Long.parseLong(right);
        for(int i=1;i<10;i++){
            palindrome.add(i+"");
        }
        for(int i=1;i<10000;i++){
            String leftpart=i+"";
            String rightpart=new StringBuilder(leftpart).reverse().toString();
            palindrome.add(leftpart+rightpart);
            for(int digit=0;digit<10;digit++){
                palindrome.add(leftpart+digit+rightpart);
            }
        }
        int count=0;
        for(String l : palindrome){
            long square=Long.parseLong(l)*Long.parseLong(l);
            if(square>=leftl && square<=rightl && isPalindrome(Long.toString(square))){
                count++;
            }
        }
        return count;
    }
    public boolean isPalindrome(String s){
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--))return false;
        }
        return true;
    }
}
