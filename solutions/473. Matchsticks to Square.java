/*class Solution {
     boolean[] vis;
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int x : matchsticks) sum+=x;
        if(sum%4!=0) return false;
        
        Arrays.sort(matchsticks,Collections.reverseOrder());
        vis=new boolean[matchsticks.length];
        int[] sides=new int[4];
        return isPossible(matchsticks,sides,sum/4);
        
    }
    public boolean isPossible(int[] matchsticks,int[] sides,int value){
        
        if(sides[0]==value && sides[1]==value && sides[2]==value && sides[3]==value) return true;
        
        for(int i=0;i<matchsticks.length;i++){
            if(!vis[i] && sides[0]+matchsticks[i]<=value){
                vis[i]=true;
                sides[0]+=matchsticks[i];
                if(isPossible(matchsticks,sides,value)) return true;
                sides[0]-=matchsticks[i];
                vis[i]=false;
            }
            if(!vis[i] && sides[1]+matchsticks[i]<=value){
                vis[i]=true;
                sides[1]+=matchsticks[i];
                if(isPossible(matchsticks,sides,value)) return true;
                sides[1]-=matchsticks[i];
                vis[i]=false;
            }
            if(!vis[i] && sides[2]+matchsticks[i]<=value){
                vis[i]=true;
                sides[2]+=matchsticks[i];
                if(isPossible(matchsticks,sides,value)) return true;
                sides[2]-=matchsticks[i];
                vis[i]=false;
            }
            if(!vis[i] && sides[3]+matchsticks[i]<=value){
                vis[i]=true;
                sides[3]+=matchsticks[i];
                if(isPossible(matchsticks,sides,value)) return true;
                sides[3]-=matchsticks[i];
                vis[i]=false;
            }
        }
        return false;
    }
}*/
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    public Solution() {
        this.sums = new int[4];
    }

    // Depth First Search function.
    public boolean dfs(int index) {

        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == this.nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // Get current matchstick.
        int element = this.nums.get(index);

        // Try adding it to each of the 4 sides (if possible)
        for(int i = 0; i < 4; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                if (this.dfs(index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }
        }

        return false;
    }

    public boolean makesquare(int[] nums) {
        // Empty matchsticks.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += nums[i];
        }

        this.possibleSquareSide =  perimeter / 4;
        if (this.possibleSquareSide * 4 != perimeter) {
            return false;
        }

        // Convert the array of primitive int to ArrayList (for sorting).
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());
        return this.dfs(0);
    }
}
