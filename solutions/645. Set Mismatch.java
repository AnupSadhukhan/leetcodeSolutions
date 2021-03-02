class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeat=0;
        HashSet<Integer> set=new HashSet<Integer>();
            int xor=0;
        int num=1;
        for(int i : nums){
            xor^=i^num++;
            if(set.contains(i) && repeat==0) repeat =i;
            else set.add(i);
            
        }
        //System.out.println("repeat "+repeat+" xor  "+xor);
        return new int[]{repeat, xor^repeat};
    }
}
