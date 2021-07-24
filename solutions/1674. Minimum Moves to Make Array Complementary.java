class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] delta = new int[2*limit + 2];
        int n = nums.length;
        // max move to make array complement is n, if we replace all element
        // considering moving a and move b, so for a pair we need 2 move
        int move = n;
        for(int i=0;i<n/2;i++){
            int a = nums[i];
            int b = nums[n-1-i];
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            
            int minSumWithOneMove = min + 1 ; // replaceing max element to 1 : a = min , b = 1
            int maxSumWithOneMove = max + limit ; // replacing min element to limit : a = max , b = limit
            
            // incase we our sum is within minSumWithOneMove and maxSumWithOneMove
            // we need only one move, previously we assumed two move for each pair
            // so we need to decrease by 1 move 
           
            delta[minSumWithOneMove]--;
            
            // if our target sum is a+b then we don't need any move so, we need to decrease it by 1, so that 
            // cumulative decrease move will be by 2, one for range another for being exact same target
           
            delta[a+b]--;
            
            // if our sum is greater than a+b, then we need only one move, as cummulative move decreased by 2
            // we need to increase a+b+1 by 1, so that it restores to one move from 2 move
           
            delta[a+b+1]++;
            
            // if target sum exceed maxSumWithOneMove, then we need to 2 move because to achieve target
            // we need to replace both a and b, so, we need to incease maxSumWithOneMove + 1 by 1
            // so that cumulative move increase to 2 again
            
            delta[maxSumWithOneMove+1]++;
            
        }
        
        // we need to calculate min move, our max Move is n
        // add all moves from 2 to 2*limit+1 and return min Move
       
        int minMove = n;
        for(int i=2;i<=2*limit+1;i++){
            
            move+=delta[i];
            minMove = Math.min(minMove, move);
        }
         
        return minMove;
    }
}
