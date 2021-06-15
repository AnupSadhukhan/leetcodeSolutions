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
​
class Solution {
    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;
​
    public Solution() {
        this.sums = new int[4];
    }
​
