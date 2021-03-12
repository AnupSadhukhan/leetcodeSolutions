class Solution {
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public int climbStairs(int n) {
        if(map.get(n)!=null) return map.get(n);
        if(n==0) return 1;
        if(n<0) return -1;
        int steps=0;
        int step1=climbStairs(n-1);
        int step2=climbStairs(n-2);
        steps+=step1>0?step1:0;
        steps+=step2>0?step2:0;
        map.put(n,steps);
        return steps;
    }
}
