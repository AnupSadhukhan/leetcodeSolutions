class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        //System.out.println("dist");
        long sum=0;
        for(int i : nums){
            sum+=i;
        }
        //System.out.println("sum "+sum);
        long dist=goal-sum;
        //System.out.println("dist "+dist);
        long min=Math.abs(dist)/Math.abs(limit);
        //System.out.println("min "+min);
        min+=(int) (Math.abs(dist)%Math.abs(limit))>0?1:0;
        return (int)min;
    }
}
