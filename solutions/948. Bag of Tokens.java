class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length==0 ) return 0;
        Arrays.sort(tokens);
        if(power<tokens[0]) return 0;
        int left = 0, right = tokens.length-1;
        int score = 0,max=0;
        
        while(left<=right){
           // System.out.println("left "+left+" right "+right+" power "+power);
            if(power>=tokens[left]){
                power-=tokens[left];
                score++;
                max = Math.max(max,score);
                left++;
            }
            else if(score>=1){
                score--;
                power+=tokens[right];
                right--;
            }
            else break;
        }
        return max;
        
    }
}
