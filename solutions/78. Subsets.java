class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       
        List<List<Integer>> li=new ArrayList<List<Integer>>();
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> list=new ArrayList<Integer>();
            int bit=i;
            while(bit>0){
                int pos=(int) (Math.log(bit & ~(bit-1))/Math.log(2));
                list.add(nums[pos]);
                bit=bit & (bit-1);
                //System.out.println("pos "+pos+" i "+i+" nums "+nums[pos]);
            }
            li.add(list);
        }
        
        return li;
    }
    
}
